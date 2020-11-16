package entity;

/**
 * @Author xlf
 * @Description 状态码
 * @Date 10:59 2020/10/19
 * @return
 **/

public enum  StatusCode {
	// public static final int OK=20000;//成功
	// public static final int ERROR =20001;//失败
	// public static final int LOGINERROR =20002;//用户名或密码错误
	// public static final int ACCESSERROR =20003;//权限不足
	// public static final int REMOTEERROR =20004;//远程调用失败
	// public static final int REPERROR =20005;//重复操作
	SUCCESS(1000, "操作成功"),
	FAILED(1001, "响应失败"),
	VALIDATE_FAILED(1002, "参数校验失败"),
	REPERROR(1003, "不可重复点赞"),
	ERROR(5000, "未知错误");
	
	private int code;
	private String msg;
	
	StatusCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	
	public int getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
}
