package com.linked.dazhongdianpingapi.system.util.threadlocal;

/**
 * @author Linked
 * @date 2020/5/4 17:00
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
