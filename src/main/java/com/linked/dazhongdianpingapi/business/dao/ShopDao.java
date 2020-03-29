package com.linked.dazhongdianpingapi.business.dao;

import com.linked.dazhongdianpingapi.business.pojo.po.Shop;
import com.linked.dazhongdianpingapi.business.pojo.vo.shop.ShopListVO;
import com.linked.dazhongdianpingapi.system.base.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Lin
 * @date 2020/1/8 16:43
 */
@Mapper
@Repository
public interface ShopDao extends MyMapper<Shop> {

    List<Shop> getShopList(ShopListVO shopListVO);
}
