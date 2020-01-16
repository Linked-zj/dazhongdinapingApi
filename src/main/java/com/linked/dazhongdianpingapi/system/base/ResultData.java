package com.linked.dazhongdianpingapi.system.base;

import com.linked.dazhongdianpingapi.system.util.threadlocal.ThreadLocalManager;
import lombok.Data;

/**
 * @Author: Cookie
 * @Date: 2019/1/15 10:38
 * @Description: 返回结果集
 */
@Data
public class ResultData<T>{
	private Integer code = 0;//结果代码
	private String message = "调用成功";//结果信息
	private T data;//数据集
    private String webToken; //网页token

    public ResultData(){
        if(ThreadLocalManager.getTokenContext()!=null) {
            this.webToken = ThreadLocalManager.getTokenContext().getToken();
        }
    }

	public ResultData(Integer code, String message) {
		this.code = code;
		this.message = message;
        if(ThreadLocalManager.getTokenContext()!=null) {
            this.webToken = ThreadLocalManager.getTokenContext().getToken();
        }
	}

	public ResultData(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
        if(ThreadLocalManager.getTokenContext()!=null) {
            this.webToken = ThreadLocalManager.getTokenContext().getToken();
        }
	}

	public ResultData(T data) {
		this.data = data;
        if(ThreadLocalManager.getTokenContext()!=null) {
            this.webToken = ThreadLocalManager.getTokenContext().getToken();
        }
	}

}
