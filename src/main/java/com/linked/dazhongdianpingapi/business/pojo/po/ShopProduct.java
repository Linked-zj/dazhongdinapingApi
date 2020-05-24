package com.linked.dazhongdianpingapi.business.pojo.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * @author Linked
 * @date 2020/3/14 16:41
 */

@Data
@Table(name = "tb_shop_product")
public class ShopProduct {

  @Id
  @GeneratedValue(generator = "JDBC")
  private Integer id;

  private Integer shopId;

  private String productName;

  private String productDesc;

  private BigDecimal originPrice;

  private BigDecimal price;

  private String imgUrl;

}
