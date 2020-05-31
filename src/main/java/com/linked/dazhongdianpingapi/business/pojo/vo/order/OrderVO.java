package com.linked.dazhongdianpingapi.business.pojo.vo.order;

import com.linked.dazhongdianpingapi.business.pojo.po.Order;
import lombok.Data;

import java.util.List;

/**
 * @author Linked
 * @date 2020/5/16 16:59
 */
@Data
public class OrderVO extends Order {

    private List<OrderProductVO> orderProductList;

    private String hashCode;


}
