package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.service.OrderItemService;

public class OrderItemServiceImpl implements OrderItemService{

	private OrderItemDao orderItemDao = new OrderItemDaoImpl();
	
	@Override
	public List<OrderItem> queryOrderItemList(String orderId) {
		return orderItemDao.getOrderItemList(orderId);
	}

	@Override
	public void saveOrderItemBatch(List<OrderItem> list) {
		orderItemDao.insertBatch(list);
	}

}
