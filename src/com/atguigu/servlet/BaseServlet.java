package com.atguigu.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据传入的action参数值作为函数名，分发调用函数
		// 解决post请求参数乱码问题
		request.setCharacterEncoding("UTF-8");
		// action参数为方法名
		String action = request.getParameter("action");
		try {
			// 这里为什么用this，因为tomcat没有new BaseServlet对象，只new 具体的Servlet对象。
			Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		// 解决响应乱码问题
		response.setContentType("text/html;charset=utf-8");
	}

}
