package com.atguigu.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.atguigu.bean.Cart;
import com.atguigu.bean.User;

/**
 * 封装参数工具类
 * @author Administrator
 *
 */
public class WebUtils {

	/**
	 * 将request中传入的参数封装进对象中<br/>
	 * 原理：根据对象中的属性名去request参数中进行匹配
	 * @return
	 */
	public static <T> T param2Bean(HttpServletRequest request, T t){
		try {
			BeanUtils.populate(t, request.getParameterMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/**
	 * 从session中获取购物车
	 * 如果没有的话创建购物车放到session中
	 */
	public static Cart getCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		
		return cart;
	}
	
	/**
	 * 从session中获取用户信息
	 * @return
	 */
	public static User getUser(HttpServletRequest request) {
		return (User)request.getSession().getAttribute("user");
	}
	
}
