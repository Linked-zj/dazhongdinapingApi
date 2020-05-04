package com.linked.dazhongdianpingapi.system.base;


public enum ErrorCode {

	//Token验证
    TOKEN_WITHOUT(10001,"无效的凭证"),
	TOKEN_INVALID(10002,"TOKEN失效"),

	//用户相关
    EMAIL_HAVE_BEEN_USED(20001,"邮箱已被占用"),
    PHONE_HAVE_BEEN_USED(20002,"手机已被占用"),
    NAME_HAVE_BEEN_USED(20003,"昵称已被占用"),
	SMS_CODE_SEND_FAIL(20004,"发送短信验证码失败"),
	SMS_CODE_FAILURE(20005,"验证码已过期"),
    SMS_CODE_WRONG(20006,"验证码错误"),
    USER_LOGIN_FAIL(20007,"密码错误"),
    EMAIL_SEND_FAIL(20008,"邮件发送失败"),
    OLD_PASSWORD_WRONG(20009,"旧密码错误"),
	USER_IS_DISABLE(20010,"用户已被禁用"),

	//用户权限相关
	DUPLICATION_OF_AUTHORITY(30001,"您已添加过该权限"),
	

	CUSTOM_WRONG(10000,"");




	private String msg;
    private int code;

    ErrorCode(int code, String msg)
    {
    	this.code=code;
        this.msg=msg;
    }

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

}

