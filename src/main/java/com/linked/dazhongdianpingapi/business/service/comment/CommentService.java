package com.linked.dazhongdianpingapi.business.service.comment;

import com.linked.dazhongdianpingapi.business.dao.CommentDao;
import com.linked.dazhongdianpingapi.business.pojo.po.Comment;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Lin 测试提交
 * @date 2020/1/6 17:23
 */
@Service
public class CommentService {
    @Autowired
    private CommentDao commentDao;


    public List<Comment> getCommentSelectedList() {
        Example example = new Example(Comment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("ifComment", 1);
        return commentDao.selectByExample(example);
    }
}
