package com.linked.dazhongdianpingapi.business.service.order;

import com.linked.dazhongdianpingapi.business.dao.OrderDao;
import com.linked.dazhongdianpingapi.business.dao.OrderProductDao;
import com.linked.dazhongdianpingapi.business.pojo.po.Order;
import com.linked.dazhongdianpingapi.business.pojo.po.OrderProduct;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderProductVO;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderProductDao orderProductDao;


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
}
