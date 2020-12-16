package com.atguigu.dao;

import java.util.List;

import com.atguigu.bean.Book;

public interface BookDao {

	/**
	 * 查询所有图书
	 * @return
	 */
	List<Book> getAllBook();
	
	/**
	 * 查询一本图书信息
	 * @return
	 */
	Book getBook(Book book);
	
	/**
	 * 插入图书
	 * @return
	 */
	int insertBook(Book book);
	
	/**
	 * 修改图书
	 * @return
	 */
	int updateBook(Book book);
	
	/**
	 * 删除图书信息
	 * @return
	 */
	int deleteBook(Book book);
	
	/**
	 * 查询分页列表
	 * @return
	 */
	List<Book> getBookListByPage(int index, int size);
	
	/**
	 * 查询总页数
	 * @return
	 */
	int getTotalCount();
	
	/**
	 * 查询分页列表
	 * 带价格区间条件
	 */
	List<Book> getBookListByPageAndParam(int index, int size, double minPrice, double maxPrice);
	
	/**
	 * 查询总页数
	 * 带价格区间条件
	 * @return
	 */
	int getTotalCountByParam(double minPrice, double maxPrice);
	
	/**
	 * 修改图书的库存和销量
	 */
	int updateSalesAndStock(Book book);
	
}
