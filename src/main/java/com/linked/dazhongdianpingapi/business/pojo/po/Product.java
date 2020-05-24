package com.linked.dazhongdianpingapi.business.pojo.po;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Linked
 * @date 2020/3/14 16:41
 */

@Data
@Table(name = "tb_product")
public class Product {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  private Integer categoryId;

  private Integer sales;

  private Integer isFlash;

  private String name;

  private Double originPrice;

  private Double price;

  private String spec;

  private String imageUrl;

  private Integer count;

  private Integer status;


}
