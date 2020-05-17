package com.linked.dazhongdianpingapi.business.pojo.po;


import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer userId;

    /**
     * 订单状态:1.已支付(待收货) 0.未支付
     */
    private Integer orderStatus;

    private BigDecimal totalAmount;

    private String receiveName;

    private String receivePhone;

    private String receiveAddress;

    /**
     * 确认收货状态 1:已收货 0:未收货
     */
    private Integer confirmStatus;

    private String receiveTime;

    private Date createTime;

    private String remark;
}
