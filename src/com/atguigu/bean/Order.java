package com.atguigu.bean;

import java.util.Date;

public class Order {

	/**
	 * 订单编号
	 */
	private String orderId;
	
	/**
	 * 创建日期
	 */
	private Date createDate;
	
	/**
	 * 总金额
	 */
	private double totalMoney;
	
	/**
	 * 订单状态 0：未发货 1：已发货 2：交易完成
	 */
	private int status;
	
	/**
	 * 用户编号
	 */
	private Integer userId;
	
	public Order() {
		super();
	}
	
	public Order(String orderId, double totalMoney, int status, Integer userId) {
		super();
		this.orderId = orderId;
		this.totalMoney = totalMoney;
		this.status = status;
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
