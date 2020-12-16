package com.atguigu.dao.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.dao.BaseDao;
import com.atguigu.dao.BookDao;

public class BookDaoImpl extends BaseDao<Book> implements BookDao{

	@Override
	public List<Book> getAllBook() {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book";
		// 可变参数可以不传
		return getBeanList(sql);
	}

	@Override
	public Book getBook(Book book) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book where id = ?";
		return getBean(sql, book.getId());
	}

	@Override
	public int insertBook(Book book) {
		String sql = "insert into bs_book(title,author,price,sales,stock) values(?,?,?,?,?)";
		return update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock());
	}

	@Override
	public int updateBook(Book book) {
		String sql = "update bs_book set title=?,author=?,price=?,sales=?,stock=? where id=?";
		return update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getId());
	}

	@Override
	public int deleteBook(Book book) {
		String sql = "delete from bs_book where id = ?";
		return update(sql, book.getId());
	}

	@Override
	public List<Book> getBookListByPage(int index, int size) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book "
				+ "limit ?, ?";
		return getBeanList(sql, index, size);
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(1) from bs_book";
		return ((Long)getValue(sql)).intValue();
	}

	@Override
	public List<Book> getBookListByPageAndParam(int index, int size, double minPrice, double maxPrice) {
		String sql = "select id,title,author,price,sales,stock,img_path imgPath from bs_book "
				+ "where price between ? and ? "
				+ "limit ?, ?";
		return getBeanList(sql, minPrice, maxPrice, index, size);
	}

	@Override
	public int getTotalCountByParam(double minPrice, double maxPrice) {
		String sql = "select count(1) from bs_book "
				+ "where price between ? and ?";
		return ((Long)getValue(sql, minPrice, maxPrice)).intValue();
	}

	@Override
	public int updateSalesAndStock(Book book) {
		String sql = "update bs_book set sales=?,stock=? where id=?";
		return update(sql, book.getSales(), book.getStock(), book.getId());
	}

}
