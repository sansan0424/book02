package com.atguigu.service.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao = new UserDaoImpl(); 
	
	@Override
	public User login(User user) {
		// 根据用户名密码查询用户信息
		return userDao.getUserByUsernameAndPassword(user);
	}

	@Override
	public boolean regist(User user) {
		// 向用户表中插入用户
		int result = userDao.insertUser(user);
		return result>0;
	}

	@Override
	public boolean userIsExist(User user) {
		// 根据用户名查询用户信息
		user = userDao.getUserByUsername(user);
		return (user!=null);
	}

}
