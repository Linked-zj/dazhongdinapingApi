package com.linked.dazhongdianpingapi.system.exception;


import com.linked.dazhongdianpingapi.system.base.ErrorCode;

/**
 * @author Linked
 * @date 2020/5/4 17:00
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 3200004685293133433L;
	private String type;// 异常类型
	private Integer errorCode;// 异常代码
	private String errorMessage;// 异常信息

	public ServiceException() {
	}

	public ServiceException(Throwable throwable, ErrorCode e) {
		super(throwable);
		this.errorMessage = e.getMsg();
		this.errorCode = e.getCode();
	}

	public ServiceException(Throwable throwable, ErrorCode e, String errorMessage) {
		super(throwable);
		this.errorMessage =  errorMessage;
		this.errorCode = e.getCode();
	}
	
	public ServiceException(ErrorCode e) {
		this.errorMessage = e.getMsg();
		this.errorCode = e.getCode();
	}

	public ServiceException(ErrorCode e, String errorMessage) {
		this.errorMessage =  errorMessage;
		this.errorCode = e.getCode();
	}

	public Integer getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return this.errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getType() {
		return this.type;
	}

	void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return this.errorMessage;
	}

	void setMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
