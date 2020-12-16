package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.bean.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.code.kaptcha.Constants;

public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	/**
	 * 登录
	 */
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装参数
		User user = WebUtils.param2Bean(request, new User());
		user = userService.login(user);
		if (user == null) {
			// 登录失败
			request.setAttribute("msg", "用户名密码错误！");
			request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
		}else {
			// 登录成功
			// 将用户信息放入session中
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect(request.getContextPath() + "/pages/user/login_success.jsp");
		}
	}
	
	/**
	 * 注册
	 */
	protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装参数
		User user = WebUtils.param2Bean(request, new User());
		
		// 校验验证码
		HttpSession session = request.getSession();
		// 获取放入session中的验证码
		String token = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (user.getCode() != null && !user.getCode().equals(token)) {
			request.setAttribute("msg", "验证码不匹配！");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
			return;
		}
		
		if (!userService.regist(user)) {
			// 注册失败
			request.setAttribute("msg", "注册失败！");
			request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
		}else {
			// 注册成功
			response.sendRedirect(request.getContextPath() + "/pages/user/regist_success.jsp");
		}
	}
	
	/**
	 * 验证用户名是否已存在
	 * ajax调用
	 */
	protected void checkUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 封装参数
		User user = WebUtils.param2Bean(request, new User());
		// 响应给前端：1：用户名已存在；0：用户名不存在
		String result = userService.userIsExist(user) ? "1" : "0";
		response.getWriter().write(result);
	}

	/**
	 * 登出
	 */
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 强制session失效
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}
	
}
