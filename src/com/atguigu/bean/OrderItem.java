package com.atguigu.bean;

public class OrderItem {

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 书名
	 */
	private String title;
	
	/**
	 * 单价
	 */
	private double price;
	
	/**
	 * 数量
	 */
	private int count;
	
	/**
	 * 总价
	 */
	private double totalMoney;
	
	/**
	 * 订单编号
	 */
	private String orderId;
	
	public OrderItem() {
		super();
	}

	public OrderItem(String title, double price, int count, double totalMoney, String orderId) {
		super();
		this.title = title;
		this.price = price;
		this.count = count;
		this.totalMoney = totalMoney;
		this.orderId = orderId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	
}
