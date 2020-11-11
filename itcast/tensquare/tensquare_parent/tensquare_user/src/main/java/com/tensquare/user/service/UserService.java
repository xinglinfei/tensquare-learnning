package com.tensquare.user.service;

import com.tensquare.user.dao.UserDao;
import com.tensquare.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserService
 * @Description
 * @Author xlf
 * @Date 2020/10/23 1:25
 **/
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User login(User user) {
		return userDao.selectOne(user);
	}
	
	public User selectById(String id) {
		return userDao.selectById(id);
	}
}
