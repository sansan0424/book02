package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Order;

public interface OrderDao {

	/**
	 * 插入订单
	 */
	int insertOrder(Order order);
	
	/**
	 * 修改订单状态
	 */
	int updateStatus(Order order);

	/**
	 * 查询所有订单列表<br/>
	 * 管理员
	 */
	List<Order> getOrderList();
	
	/**
	 * 根据用户编号查询订单列表
	 */
	List<Order> getOrderListByUserId(Integer userId);
}
