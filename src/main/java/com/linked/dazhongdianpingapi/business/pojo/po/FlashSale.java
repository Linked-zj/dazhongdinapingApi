package com.linked.dazhongdianpingapi.business.pojo.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lin
 * @date 2020/1/3 15:06
 */
@Data
@Table(name = "tb_flash_sale")
public class FlashSale {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String name;

    private Double price;

    private Double originPrice;

    private String imageUrl;

    private String spec;

    private Integer count;

    private Integer sales;

    private Integer status;

}
