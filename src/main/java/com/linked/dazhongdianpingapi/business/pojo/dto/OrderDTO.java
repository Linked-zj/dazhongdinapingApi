package com.linked.dazhongdianpingapi.business.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Linked
 * @date 2020/5/16 20:45
 */
@Data
public class OrderDTO {

    private Integer orderId;


    private BigDecimal totalAmount;

    private Integer status;

    private List<OrderProductDTO> orderProductList;

}
