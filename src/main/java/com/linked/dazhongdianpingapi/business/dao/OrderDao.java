package com.linked.dazhongdianpingapi.business.dao;

import com.linked.dazhongdianpingapi.business.pojo.dto.OrderDTO;
import com.linked.dazhongdianpingapi.business.pojo.po.Order;
import com.linked.dazhongdianpingapi.business.pojo.vo.order.OrderListVO;
import com.linked.dazhongdianpingapi.system.base.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Linked
 * @date 2020/5/11 17:38
 */
@Mapper
@Repository
public interface OrderDao extends MyMapper<Order> {

    List<OrderDTO> getOrderList(OrderListVO orderListVO);

}
