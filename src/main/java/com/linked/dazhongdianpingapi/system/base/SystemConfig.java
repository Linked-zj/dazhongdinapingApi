package com.linked.dazhongdianpingapi.system.base;

/**
 * @Author: Cookie
 * @Description: 系统常量配置
 * @Date: Create in 16:47 2019/1/15
 */
public class SystemConfig {

    /**
     * web端token传输标识
     */
    public static String WEB_TOKEN = "Authorization";

    /**
     * app端token传输标识
     */
    public static String APP_TOKEN = "tokenApp";

    /**
     * 登陆方式 1：WEB登陆
     */
    public static Integer LOGIN_WEB = 1;

    /**
     * 登陆方式 2：APP登陆
     */
    public static Integer LOGIN_APP = 2;

    /**
     * web Token 需修改时间(毫秒单位
     */
    public static long MODIFY_TOKEN_TIME = 30 * 60 * 1000;

    /**
     * web Token 过期时间(毫秒单位
     */
    public static long OVERDUE_TOKEN_TIME = 60 * 60 * 1000;

    /**
     * web Token redis中TOKEN删除时间(毫秒单位
     */
    public static long REDIS_DELETE_TOKEN_TIME = 2 * 60 * 60 * 1000;
}
