package com.linked.dazhongdianpingapi.business.dao;

import com.linked.dazhongdianpingapi.business.pojo.po.HeadLine;
import com.linked.dazhongdianpingapi.system.base.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lin
 * @date 2019/12/27 14:50
 */
@Mapper
@Repository
public interface HeadLineDao extends MyMapper<HeadLine> {


}
