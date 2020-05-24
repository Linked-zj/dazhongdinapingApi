package com.linked.dazhongdianpingapi.business.service.order;

import com.google.common.util.concurrent.RateLimiter;
import com.linked.dazhongdianpingapi.business.dao.OrderDao;
import com.linked.dazhongdianpingapi.business.dao.OrderProductDao;
import com.linked.dazhongdianpingapi.business.dao.ProductDao;
import com.linked.dazhongdianpingapi.business.pojo.po.Order;
import com.linked.dazhongdianpingapi.business.pojo.po.OrderProduct;
import com.linked.dazhongdianpingapi.business.pojo.po.Product;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderProductVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderVO;
import com.linked.dazhongdianpingapi.system.base.ErrorCode;
import com.linked.dazhongdianpingapi.system.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Linked
 * @date 2020/5/11 17:46
 */
@Slf4j
@Service
public class OrderProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProductService.class);

    @Autowired
    private ProductDao productDao;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderProductDao orderProductDao;

    //每秒放行10个请求
    RateLimiter rateLimiter = RateLimiter.create(10);

    public Integer insertOrderProduct(OrderVO orderVO) {
        int flag = 0;
        Order order = new Order();
        BeanUtils.copyProperties(orderVO, order);
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
                // product.setSales(product.getSales() + orderProductVO.getNum());
                Integer count = productDao.updateStack(product);
                if (count == 0) {
                    throw new ServiceException(ErrorCode.CUSTOM_WRONG, "乐观锁更新失败");
                }
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setProductId(orderProductVO.getId());
                orderProduct.setNum(orderProductVO.getNum());
                orderProduct.setOrderId(order.getId());
                orderProduct.setCreateTime(new Date());
                orderProductList.add(orderProduct);
                System.out.println("购买成功===================卖出:" + product.getSales() + orderProductVO.getNum());
                LOGGER.info("购买成功===================卖出{}",product.getSales() + orderProductVO.getNum());
            }
            flag = orderProductDao.insertList(orderProductList);
        }
        return flag;
    }


}
