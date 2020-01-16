package com.linked.dazhongdianpingapi.business.pojo.po;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lin
 * @date 2019/12/27 14:44
 */
@Data
@Table(name = "tb_head_line")
public class HeadLine {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;


    private String name;


    private String imgUrl;
}
