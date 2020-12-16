package com.atguigu.bean;

import java.io.Serializable;

/**
 * 用户类
 * @author Administrator
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = -6402879612956562117L;

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/*
	 * 验证码
	 */
	private String code;

	public User() {
		super();
	}

	public User(Integer id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
