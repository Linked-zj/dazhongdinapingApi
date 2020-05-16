package com.linked.dazhongdianpingapi.business.pojo.po;


import lombok.Data;

import javax.persistence.Table;

/**
 * @author Lin
 * @date 2019/12/27 14:44
 */
@Data
@Table(name = "tb_order_product")
public class OrderProduct {

  private Integer id;

  private Integer orderId;

  private Integer productId;

  private String productName;

  private Integer productQuantity;

}
