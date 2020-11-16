package com.tensquare.user.advice;

import com.tensquare.user.exception.APIException;
import entity.Result;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ExceptionControllerAdvice
 * @Description 参数校验全局处理类
 * @Author xlf
 * @Date 2020/11/11 15:49
 **/
@RestControllerAdvice
public class ExceptionControllerAdvice {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		//从异常中拿到objectError对象
		ObjectError error = e.getBindingResult().getAllErrors().get(0);
		//提取错误信息并返回
		String errorMessage = error.getDefaultMessage();
		return new Result(false, 1001, errorMessage);
	}
	
	@ExceptionHandler(APIException.class)
	public Result APIException(APIException e) {
		return new Result(false, e.getCode(), e.getMessage());
	}
}
