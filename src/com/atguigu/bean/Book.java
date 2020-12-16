package com.atguigu.bean;

import java.io.Serializable;

public class Book implements Serializable{

	private static final long serialVersionUID = -1081937702777200830L;

	/**
	 * 主键
	 */
	private Integer id;
	
	/**
	 * 书名
	 */
	private String title;
	
	/**
	 * 作者
	 */
	private String author;
	
	/**
	 * 价格
	 */
	private double price;
	
	/**
	 * 销量
	 */
	private int sales;
	
	/**
	 * 库存
	 */
	private int stock;
	
	/**
	 * 图书封面路径
	 */
	private String imgPath;

	public Book() {
		super();
	}

	public Book(Integer id, int sales, int stock) {
		super();
		this.id = id;
		this.sales = sales;
		this.stock = stock;
	}
	
	public Book(Integer id, String title, String author, double price, int sales, int stock, String imgPath) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
		this.sales = sales;
		this.stock = stock;
		this.imgPath = imgPath;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSales() {
		return sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	
}
