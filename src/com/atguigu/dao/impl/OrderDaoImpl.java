package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Order;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderDao;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao{

	@Override
	public int insertOrder(Order order) {
		String sql = "insert into bs_order(order_id,create_date,total_money,status,user_id) "
				+ "values(?,curdate(),?,?,?)";
		return update(sql, order.getOrderId(), order.getTotalMoney(), order.getStatus(), order.getUserId());
	}

	@Override
	public int updateStatus(Order order) {
		String sql = "update bs_order set status = ? where order_id = ?";
		return update(sql, order.getStatus(), order.getOrderId());
	}

	@Override
	public List<Order> getOrderList() {
		String sql = "select order_id orderId,create_date createDate,total_money totalMoney,"
				+ "status,user_id userId from bs_order";
		return getBeanList(sql);
	}

	@Override
	public List<Order> getOrderListByUserId(Integer userId) {
		String sql = "select order_id orderId,create_date createDate,total_money totalMoney,"
				+ "status,user_id userId from bs_order "
				+ "where user_id = ?";
		return getBeanList(sql, userId);
	}

}
