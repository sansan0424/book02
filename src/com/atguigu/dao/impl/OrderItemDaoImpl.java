package com.atguigu.dao.impl;

import java.util.Arrays;
import java.util.List;

import com.atguigu.bean.OrderItem;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;

public class OrderItemDaoImpl extends BaseDao<OrderItem> implements OrderItemDao{

	@Override
	public List<OrderItem> getOrderItemList(String orderId) {
		String sql = "select id,title,price,count,total_money totalMoney from bs_order_item "
				+ "where order_id = ?";
		return getBeanList(sql, orderId);
	}

	@Override
	public int insertBatch(List<OrderItem> list) {
		String sql = "insert into bs_order_item(title,price,count,total_money,order_id) "
				+ "values(?,?,?,?,?)";
		// list封装为二维数组
		Object[][] params = new Object[list.size()][5];
		for (int i=0; i<list.size(); i++) {
			OrderItem item = list.get(i);
			params[i] = new Object[] {item.getTitle(), item.getPrice(), item.getCount(), item.getTotalMoney(), item.getOrderId()};
		}
		
		int[] result = batch(sql, params);
		// 数组内的数相加得到总影响行数
		return Arrays.stream(result).reduce(0, Integer::sum);
	}

}
