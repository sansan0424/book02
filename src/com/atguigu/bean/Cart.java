package com.atguigu.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;

/**
 * 购物车
 * @author Administrator
 *
 */
public class Cart implements Serializable{
	
	private static final long serialVersionUID = -6065934705682045599L;
	
	private BookService bookService = new BookServiceImpl();

	/**
	 * 购物项
	 * key是bookId
	 */
	private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();
	
	/**
	 * 购物车总商品数
	 */
	private int totalCount;
	
	/**
	 * 购物车总金额
	 */
	private double totalMoney;

	public Cart() {
		super();
	}

	public Cart(Map<Integer, CartItem> items, int totalCount, double totalMoney) {
		super();
		this.items = items;
		this.totalCount = totalCount;
		this.totalMoney = totalMoney;
	}

	public int getTotalCount() {
		// 循环购物项计算出商品总数
		totalCount = 0;
		for (CartItem item : items.values()) {
			totalCount = totalCount + item.getCount();
		}
		return totalCount;
	}

	public double getTotalMoney() {
		// 循环购物项计算总金额
		totalMoney = 0;
		for (CartItem item : items.values()) {
			totalMoney = new BigDecimal(""+totalMoney).add(new BigDecimal(""+item.getTotalPrice())).doubleValue();
		}
		// 浮点数运算精度不准
		return totalMoney;
	}
	
	/**
	 * 添加购物项到购物车
	 * 传入了图书编码
	 */
	public void addBook2Cart(Book book) {
		if (items.containsKey(book.getId())) {
			// 购物项中已存在该商品
			CartItem item = items.get(book.getId());
			item.setCount(item.getCount() + 1);
			items.put(book.getId(), item);
		}else {
			// 购物项中已不存在该商品
			CartItem item = new CartItem();
			// 查询商品信息
			book = bookService.queryBook(book);
			item.setBook(book);
			item.setCount(1);
			items.put(book.getId(), item);
		}
	}
	
	/**
	 * 删除购物项
	 */
	public void deleteItem(Book book) {
		items.remove(book.getId());
	}
	
	/**
	 * 修改某一购物项的数量
	 */
	public void updateCount(Book book, int count) {
		CartItem item = items.get(book.getId());
		item.setCount(count);
		items.put(book.getId(), item);
	}
	
	/**
	 * 获取购物项列表
	 */
	public List<CartItem> getItems(){
		return new ArrayList<CartItem>(items.values());
	}
	
	/**
	 * 清空购物车
	 */
	public void clear() {
		items.clear();
	}
	
}
