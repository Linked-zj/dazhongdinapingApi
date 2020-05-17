package com.linked.dazhongdianpingapi.business.pojo.po;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Lin
 * @date 2019/12/27 14:44
 */
@Data
@Table(name = "tb_order_product")
public class OrderProduct {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  private Integer orderId;

  private Integer productId;

  private Integer num;

  private Date createTime;
}
