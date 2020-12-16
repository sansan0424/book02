package com.atguigu.service;

import com.atguigu.bean.User;

/**
 * 用户service
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 用户登录
	 * @return
	 */
	User login(User user);
	
	/**
	 * 用户注册
	 * @return
	 */
	boolean regist(User user);
	
	/**
	 * 用户是否已存在
	 * @return
	 */
	boolean userIsExist(User user);
	
}
