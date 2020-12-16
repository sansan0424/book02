package com.atguigu.bean;

import java.io.Serializable;

/**
 * 购物项
 * @author Administrator
 *
 */
public class CartItem implements Serializable{

	private static final long serialVersionUID = -1163451305230981131L;

	/**
	 * 图书信息
	 */
	private Book book;
	
	/**
	 * 当前购物项数量
	 */
	private int count;
	
	/**
	 * 当前购物项总金额
	 * 计算得到
	 */
	private double totalPrice;

	public CartItem() {
		super();
	}

	public CartItem(Book book, int count, double totalPrice) {
		super();
		this.book = book;
		this.count = count;
		this.totalPrice = totalPrice;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getTotalPrice() {
		totalPrice = book.getPrice() * count;
		return totalPrice;
	}

}
