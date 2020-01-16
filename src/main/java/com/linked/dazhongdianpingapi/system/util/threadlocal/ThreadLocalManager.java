package com.linked.dazhongdianpingapi.system.util.threadlocal;

/**
 * @Author: Cookie
 * @Date: 2019/1/15 16:55
 * @Description: 存储token中用户相关数据
 */
public class ThreadLocalManager {
	
	private static ThreadLocal<TokenContext> tokenContext = new ThreadLocal<TokenContext>();

	public static TokenContext getTokenContext() {
		return tokenContext.get();
	}

	/**
	 * @Author: Cookie
	 * @Date: 2019/1/19 10:08
	 * @Description: 获取当前登陆用户id
	 */
	public static Integer getUserId(){
        return tokenContext.get().getUserId();
    }

	public static void setTokenContext(TokenContext token) {
		tokenContext.set(token);
	}
	public static void removeTokenContext() {
		tokenContext.remove();
	}
}
