package com.linked.dazhongdianpingapi.system.util.threadlocal;

import lombok.Data;

/**
 * @Author: Cookie
 * @Date: 2019/1/15 16:56
 * @Description: 保存至redis中用户信息（可添加
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
