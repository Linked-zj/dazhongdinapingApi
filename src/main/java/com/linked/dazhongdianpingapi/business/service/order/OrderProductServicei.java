package com.linked.dazhongdianpingapi.business.service.order;

import com.google.common.util.concurrent.RateLimiter;
import com.linked.dazhongdianpingapi.business.dao.OrderDao;
import com.linked.dazhongdianpingapi.business.dao.OrderProductDao;
import com.linked.dazhongdianpingapi.business.dao.ProductDao;
import com.linked.dazhongdianpingapi.business.pojo.po.Order;
import com.linked.dazhongdianpingapi.business.pojo.po.OrderProduct;
import com.linked.dazhongdianpingapi.business.pojo.po.Product;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.HashVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderProductVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderVO;
import com.linked.dazhongdianpingapi.system.base.ErrorCode;
import com.linked.dazhongdianpingapi.system.enums.CacheKey;
import com.linked.dazhongdianpingapi.system.exception.ServiceException;
import com.linked.dazhongdianpingapi.system.util.redis.RedisUtil;
import com.linked.dazhongdianpingapi.system.util.threadlocal.ThreadLocalManager;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Linked
 * @date 2020/5/11 17:46
 */
@Slf4j
@Service
public class OrderProductServicei {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProductServicei.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderProductDao orderProductDao;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 每秒放行10个请求
     */
    RateLimiter rateLimiter = RateLimiter.create(10);

    /**
     * 延时时间：预估读数据库数据业务逻辑的耗时，用来做缓存再删除
     */
    private static final int DELAY_MILLSECONDS = 1000;

    /**
     * 延时双删线程池
     */
    private static ExecutorService cachedThreadPool = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());


    public Integer insertOrderProduct(OrderVO orderVO) {
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            throw new ServiceException(ErrorCode.CUSTOM_WRONG, "当前系统繁忙");
        }
        // 校验hash值
        String hashKey = CacheKey.HASH_KEY.getKey() + "_" + orderVO.getOrderProductList().get(0).getId() + "_" + ThreadLocalManager.getTokenContext().getUserId();
        String verifyHashInRedis = (String) redisUtil.get(hashKey);
        if (!orderVO.getHashCode().equals(verifyHashInRedis)) {
            throw new ServiceException(ErrorCode.CUSTOM_WRONG, "抢购失败");
        }
        LOGGER.info("等待时间" + rateLimiter.acquire());
        int flag = 0;
        Order order = new Order();
        BeanUtils.copyProperties(orderVO, order);
        order.setUserId(ThreadLocalManager.getUserId());
        order.setConfirmStatus(0);
        order.setOrderStatus(1);
        order.setCreateTime(new Date());
        orderDao.insertUseGeneratedKeys(order);
        if (order.getId() != null) {
            List<OrderProduct> orderProductList = new ArrayList<>();
            for (OrderProductVO orderProductVO : orderVO.getOrderProductList()) {
                Product product = productDao.selectByPrimaryKey(orderProductVO.getId());
                if (product.getSales().equals(product.getCount())) {
                    throw new ServiceException(ErrorCode.CUSTOM_WRONG, "已售罄");
                }
                // 删除缓存
                delStockCountCache(orderProductVO.getId());
                // 更新库存
                Integer count = productDao.updateStack(product);
                // 异步删除缓存
                cachedThreadPool.execute(new delCacheByThread(orderProductVO.getId()));
                if (count == 0) {
                    throw new ServiceException(ErrorCode.CUSTOM_WRONG, "乐观锁更新失败");
                }
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setProductId(orderProductVO.getId());
                orderProduct.setNum(orderProductVO.getNum());
                orderProduct.setOrderId(order.getId());
                orderProduct.setCreateTime(new Date());
                orderProductList.add(orderProduct);
            }
            flag = orderProductDao.insertList(orderProductList);
        }
        return flag;
    }

    /**
     * 校验hash
     *
     * @param hashVO
     * @return
     */
    public String getVerifyHash(HashVO hashVO) {
        // 生成hash
        String verify = CacheKey.HASH_KEY.getKey() + hashVO.getProductId() + hashVO.getUserId();
        String verifyHash = DigestUtils.md5DigestAsHex(verify.getBytes());
        // 将hash和用户商品信息存入redis
        String hashKey = CacheKey.HASH_KEY.getKey() + "_" + hashVO.getProductId() + "_" + hashVO.getUserId();
        redisUtil.set(hashKey, verifyHash, 3600);
        return verifyHash;
    }

    /**
     * 删除缓存
     *
     * @param id
     */
    public void delStockCountCache(int id) {
        String hashKey = "PRODUCT_DETAIL_" + id;
        redisUtil.remove(hashKey);
    }


    /**
     * 缓存再删除线程
     */
    private class delCacheByThread implements Runnable {
        private int sid;
        public delCacheByThread(int sid) {
            this.sid = sid;
        }
        public void run() {
            try {
                LOGGER.info("异步执行缓存再删除，商品id：[{}]， 首先休眠：[{}] 毫秒", sid, DELAY_MILLSECONDS);
                Thread.sleep(DELAY_MILLSECONDS);
                delStockCountCache(sid);
                LOGGER.info("再次删除商品id：[{}] 缓存", sid);
            } catch (Exception e) {
                LOGGER.error("delCacheByThread执行出错", e);
            }
        }
    }


}
