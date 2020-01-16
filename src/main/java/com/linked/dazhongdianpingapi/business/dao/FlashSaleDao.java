package com.linked.dazhongdianpingapi.business.dao;

import com.linked.dazhongdianpingapi.business.pojo.po.FlashSale;
import com.linked.dazhongdianpingapi.business.pojo.po.HeadLine;
import com.linked.dazhongdianpingapi.system.base.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lin
 * @date 2020/1/3 15:09
 */

@Mapper
@Repository
public interface FlashSaleDao extends MyMapper<FlashSale> {

}
