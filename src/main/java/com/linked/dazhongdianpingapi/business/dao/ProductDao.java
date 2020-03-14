package com.linked.dazhongdianpingapi.business.dao;

import com.linked.dazhongdianpingapi.business.pojo.po.Product;
import com.linked.dazhongdianpingapi.system.base.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Linked
 * @date 2020/3/14 21:46
 */
@Mapper
@Repository
public interface ProductDao extends MyMapper<Product> {
}
