package com.atguigu.dao.impl;

import com.atguigu.bean.User;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.UserDao;

/**
 * 用户dao实现
 * @author Administrator
 *
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao{

	@Override
	public User getUserByUsernameAndPassword(User user) {
		String sql = "select * from bs_user where username = ? and password=?";
		user = getBean(sql, user.getUsername(), user.getPassword());
		return user;
	}

	@Override
	public int insertUser(User user) {
		String sql = "insert into bs_user(username, password, email) values(?, ?, ?)";
		return update(sql, user.getUsername(), user.getPassword(), user.getEmail());
	}

	@Override
	public User getUserByUsername(User user) {
		String sql = "select * from bs_user where username = ?";
		user = getBean(sql, user.getUsername());
		return user;
	}

}
