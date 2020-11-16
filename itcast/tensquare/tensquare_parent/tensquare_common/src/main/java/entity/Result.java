package entity;

/**
 * @CLassName Result
 * @Description 通用结果集
 * @Author xlf
 * @Date 2020/10/19 10:52
 **/
public class Result<T> {
	private boolean flag;
	private Integer code;
	private String message;
	private T data;
	
	public Result() {
	}
	
	public Result(T data) {
		this(StatusCode.SUCCESS
			
			,data);
	}
	
	
	public Result(boolean flag, Integer code, String message) {
		this.flag = flag;
		this.code = code;
		this.message = message;
	}
	
	public Result(boolean flag, Integer code, String message, T data) {
		this.flag = flag;
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
	public Result(StatusCode code, T data) {
		this.code = code.getCode();
		this.message = code.getMsg();
		this.data = data;
	}
	
	public boolean isFlag() {
		return flag;
	}
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Result{" +
			"flag=" + flag +
			", code=" + code +
			", message='" + message + '\'' +
			", data=" + data +
			'}';
	}
}
