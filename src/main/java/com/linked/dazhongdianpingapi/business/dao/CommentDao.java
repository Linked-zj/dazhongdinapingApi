package com.linked.dazhongdianpingapi.business.dao;

import com.linked.dazhongdianpingapi.business.pojo.po.Comment;
import com.linked.dazhongdianpingapi.business.pojo.po.HeadLine;
import com.linked.dazhongdianpingapi.system.base.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author Lin
 * @date 2020/1/6 17:24
 */
@Mapper
@Repository
public interface CommentDao extends MyMapper<Comment> {


}
