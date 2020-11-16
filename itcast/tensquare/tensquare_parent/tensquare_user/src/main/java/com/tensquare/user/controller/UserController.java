package com.tensquare.user.controller;

import com.tensquare.user.pojo.User;
import com.tensquare.user.service.UserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ClassName UserController
 * @Description
 * @Author xlf
 * @Date 2020/10/23 1:36
 **/
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(@RequestBody @Valid User user/*, BindingResult bindingResult*/) {
		// for (ObjectError allError : bindingResult.getAllErrors()) {
		// 	return new Result(false, StatusCode.ERROR, allError.getDefaultMessage());
		// }
		User result = userService.login(user);
		if (result != null){
			return new Result(true, StatusCode.SUCCESS.getCode(), "登录成功", result);
		}
		return new Result(false, StatusCode.SUCCESS.getCode(), "登录失败");
	}
	//根据用户id查询用户
	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public Result selectById(@PathVariable String userId){
		User user = userService.selectById(userId);
		return new Result(true, StatusCode.SUCCESS.getCode(), "查询成功", user);
	}
}
