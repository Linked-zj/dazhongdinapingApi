package com.linked.dazhongdianpingapi.business.pojo.dto;

import com.linked.dazhongdianpingapi.business.pojo.po.Comment;
import com.linked.dazhongdianpingapi.business.pojo.po.Shop;
import lombok.Data;

import java.util.List;

/**
 * @author Linked
 * @date 2020/4/11 23:52
 */
@Data
public class ShopDetailDTO {

    private Shop shop;

    private List<Comment> comments;
}
