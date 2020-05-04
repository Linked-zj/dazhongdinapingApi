package com.linked.dazhongdianpingapi.system.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
@Data
public class PageParam implements Serializable {


    @ApiModelProperty(value = "当前页")
    private int pageNum = 1;

    @ApiModelProperty(value = "查询的记录数")
    private int pageSize = 10;

}
