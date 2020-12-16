package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;

public interface OrderService {

	/**
	 * 保存订单
	 */
	public String saveOrder(Cart cart, Integer userId);
	
	/**
	 * 修改订单状态
	 */
	public void updateOrder(String orderId, int status);
	
	/**
	 * 查询所有订单
	 */
	public List<Order> queryOrderList();
	
	/**
	 * 查询用户所有订单
	 */
	public List<Order> queryOrderListByUserId(Integer userId);
	
}
