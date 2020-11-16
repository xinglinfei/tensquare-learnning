package com.tensquare.article.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName BaseExceptionHandler
 * @Description
 * @Author xlf
 * @Date 2020/10/20 1:02
 **/
@ControllerAdvice
public class BaseExceptionHandler {
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result handler(Exception e){
		System.out.println("处理异常");
		
		return new Result(false, StatusCode.ERROR.getCode(), e.getMessage());
	}
}
