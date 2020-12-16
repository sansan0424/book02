package com.atguigu.service;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;

public interface BookService {

	/**
	 * 查询所有图书
	 * @return
	 */
	List<Book> queryAllBook();
	
	/**
	 * 查询图书信息
	 * @return
	 */
	Book queryBook(Book book);

	/**
	 *	新增图书 
	 */
	void addBook(Book book);
	
	/**
	 * 修改图书
	 * @param book
	 */
	void updateBook(Book book);
	
	/**
	 * 删除图书
	 * @param book
	 */
	void deleteBook(Book book);
	
	/**
	 * 查询图书分页信息
	 * @return
	 */
	Page<Book> queryBookPage(Page<Book> page);
	
	/**
	 * 查询图书分页信息
	 * 带查询条件：价格区间
	 */
	Page<Book> queryBookPageByParam(Page<Book> page, String minPrice, String maxPrice);
	
	/**
	 * 修改图书的库存和销量
	 */
	void updateSalesAndStock(Book book);
}
