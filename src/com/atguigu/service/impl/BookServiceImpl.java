package com.atguigu.service.impl;

import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.service.BookService;

public class BookServiceImpl implements BookService{

	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public List<Book> queryAllBook() {
		return bookDao.getAllBook();
	}

	@Override
	public Book queryBook(Book book) {
		return bookDao.getBook(book);
	}

	@Override
	public void addBook(Book book) {
		bookDao.insertBook(book);
	}

	@Override
	public void updateBook(Book book) {
		bookDao.updateBook(book);
	}

	@Override
	public void deleteBook(Book book) {
		bookDao.deleteBook(book);
	}

	@Override
	public Page<Book> queryBookPage(Page<Book> page) {
		// 查询总页数
		int totalCount = bookDao.getTotalCount();
		page.setTotalCount(totalCount);
		
		List<Book> list = bookDao.getBookListByPage(page.getIndex(), page.getPageSize());
		page.setPageData(list);
		
		return page;
	}

	@Override
	public Page<Book> queryBookPageByParam(Page<Book> page, String minPrice, String maxPrice) {
		
		double min = 0.0;
		try {
			min = Double.parseDouble(minPrice);
		} catch (Exception e) {
			
		}
		
		double max = Double.MAX_VALUE;
		try {
			max = Double.parseDouble(maxPrice);
		} catch (Exception e) {
			
		}
		
		// 查询总页数
		int totalCount = bookDao.getTotalCountByParam(min, max);
		page.setTotalCount(totalCount);
		
		List<Book> list = bookDao.getBookListByPageAndParam(page.getIndex(), page.getPageSize(), min, max);
		page.setPageData(list);
		
		return page;
	}

	@Override
	public void updateSalesAndStock(Book book) {
		bookDao.updateSalesAndStock(book);
	}

}
