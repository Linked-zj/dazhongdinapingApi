package com.linked.dazhongdianpingapi.business.pojo.dto;

import com.linked.dazhongdianpingapi.business.pojo.po.Comment;
import com.linked.dazhongdianpingapi.business.pojo.po.Product;
import lombok.Data;

import java.util.List;

/**
 * @author Linked
 * @date 2020/3/14 21:51
 */
@Data
public class ProductDTO extends Product {

    private List<Comment> comments;

}
