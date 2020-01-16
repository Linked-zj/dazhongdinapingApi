package com.linked.dazhongdianpingapi.business.pojo.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lin
 * @date 2020/1/8 16:41
 */
@Data
@Table(name = "tb_shop")
public class Shop {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer shopCategoryId;

    private String shopAreaId;

    private Integer pritory;

    private String shopName;

    private String shopDesc;

    private Integer shopAvgPrice;

    private String shopPhone;

    private String shopAddress;

    private Float shopRate;

    private String createTime;

    private String lastEditTime;

    private String shopLongitude;

    private String shopLatitude;

    private String shopImage1;

    private String shopImage2;

    private String shopImage3;

}
