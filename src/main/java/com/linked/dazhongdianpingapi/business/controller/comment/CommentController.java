package com.linked.dazhongdianpingapi.business.controller.comment;

import com.linked.dazhongdianpingapi.business.pojo.po.Comment;
import com.linked.dazhongdianpingapi.business.service.comment.CommentService;
import com.linked.dazhongdianpingapi.system.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lin 测试提交
 * @date 2020/1/6 17:16
 */
//这是master的注释
@Api("评论相关")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/select")
    @ApiOperation("获取精选评论")
    public ResultData<List<Comment>> getCommentSelected() {
        return new ResultData<>(0, "获取成功", commentService.getCommentSelectedList());
    }
}
