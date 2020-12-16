package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.OrderItem;

public interface OrderItemDao {

	/**
	 * 根据订单编号查询订单项列表
	 */
	List<OrderItem> getOrderItemList(String orderId);

	/**
	 * 批量插入订单项
	 */
	int insertBatch(List<OrderItem> list);
}
