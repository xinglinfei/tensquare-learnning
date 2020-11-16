package com.tensquare.user.exception;

/**
 * @ClassName APIException
 * @Description 自定义异常
 * @Author xlf
 * @Date 2020/11/11 15:59
 **/
public class APIException extends RuntimeException{
	private int code;
	private String msg;
	
	public APIException() {
		this(1001,"接口错误");
	}
	
	public APIException(String msg) {
		this(1001, msg);
	}
	
	public APIException(int code, String msg) {
		super(msg);
		this.code=code;
		this.msg=msg;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
}
