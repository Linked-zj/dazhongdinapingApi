package com.linked.dazhongdianpingapi.business.service.order;

import com.linked.dazhongdianpingapi.business.dao.OrderDao;
import com.linked.dazhongdianpingapi.business.pojo.dto.OrderDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.Order;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderListVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Linked
 * @date 2020/5/11 17:38
 */
@Slf4j
@Service
public class OrderService {

    @Autowired
    private OrderDao orderDao;

    /**
     * 订单列表
     * @param orderListVO
     * @return
     */
    public List<OrderDTO> getOrderList(OrderListVO orderListVO) {
        return orderDao.getOrderList(orderListVO);
    }

    /**
     * 订单状态
     * @param id
     * @return
     */
    public Integer saveOrder(Integer id) {
        Order order = new Order();
        order.setId(id);
        order.setConfirmStatus(1);
        return orderDao.updateByPrimaryKeySelective(order);
    }

}
