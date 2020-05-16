package com.linked.dazhongdianpingapi.business.pojo.po;


import lombok.Data;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Lin
 * @date 2019/12/27 14:44
 */
@Data
@Table(name = "tb_order")
public class Order {

    private Integer id;

    private Integer userId;

    private Integer orderStatus;

    private BigDecimal totalAmount;

    private String receiveName;

    private String receivePhone;

    private String receiveAddress;

    private Integer confirmStatus;

    private Date receiveTime;

    private Date createTime;


}
