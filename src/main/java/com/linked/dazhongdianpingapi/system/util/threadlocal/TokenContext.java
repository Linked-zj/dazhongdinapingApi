package com.linked.dazhongdianpingapi.system.util.threadlocal;

import lombok.Data;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
@Data
public class TokenContext {

    /**
     * 用户id
     */
	private Integer userId;

    /**
     * 1.PC端用户
     * 2.App用户
     */
	private Integer type;

    /**
     * Token创建时间
     */
    private Long createTime;

    /**
     * token
     */
    private String token;

}
