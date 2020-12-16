package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.OrderItem;

public interface OrderItemService {

	/**
	 * 查询某个订单下的所有订单项
	 */
	List<OrderItem> queryOrderItemList(String orderId);

	/**
	 * 批量保存订单项
	 */
	void saveOrderItemBatch(List<OrderItem> list);
	
}
