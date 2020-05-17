package com.linked.dazhongdianpingapi.business.pojo.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Linked
 * @date 2020/5/16 23:11
 */
@Data
public class OrderProductDTO {

    private String imageUrl;

    private String name;

    private BigDecimal price;

    private Integer num;
}
