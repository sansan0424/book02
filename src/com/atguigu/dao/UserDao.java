package com.atguigu.dao;

import com.atguigu.bean.User;

/**
 * 用户dao接口
 * @author Administrator
 *
 */
public interface UserDao {

	/**
	 * 根据用户名和密码查询用户信息
	 * @return
	 */
	User getUserByUsernameAndPassword(User user);
	
	/**
	 * 插入用户信息
	 * @return
	 */
	int insertUser(User user);
	
	/**
	 * 根据用户名查询用户信息
	 * @return
	 */
	User getUserByUsername(User user);
}
