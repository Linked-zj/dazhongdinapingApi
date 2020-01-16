package com.linked.dazhongdianpingapi.business.pojo.po;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lin
 * @date 2020/1/6 17:18
 */
@Data
@Table(name = "tb_comment")
public class Comment {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private Integer userId;

    private String userName;

    private String userAvatarImg;

    private Integer shopCommentedId;

    private Integer productCommentedId;

    private Integer ifComment;

    private String commentInfo;
    private String commentImg1;
    private String commentImg2;
    private String commentImg3;
    private String commentImg4;
    private String commentImg5;
    private String commentImg6;

    private String createTime;

}
