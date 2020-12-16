package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

/**
 * 图书管理
 * @author Administrator
 *
 */
public class BookManageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService bookService = new BookServiceImpl();
	
	/**
	 * 跳转图书列表
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Book> list = bookService.queryAllBook();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	
	/**
	 * 添加或修改图书提交
	 */
	protected void save(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 根据参数中是否有id判断是添加保存还是修改保存
		Book book = WebUtils.param2Bean(request, new Book());
		if (book.getId() == 0) {
			// 添加
			bookService.addBook(book);
		}else {
			// 修改
			bookService.updateBook(book);
		}
		// 跳转到图书列表
		response.sendRedirect(request.getContextPath()+"/BookManageServlet?action=list");
	}
	
	/**
	 * 删除图书
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2Bean(request, new Book());
		bookService.deleteBook(book);
		// 跳回图书列表
		response.sendRedirect(request.getHeader("referer"));
	}

	/**
	 * 跳转修改图书页面
	 */
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2Bean(request, new Book());
		// 查询图书信息
		book = bookService.queryBook(book);
		request.setAttribute("book", book);
		// 跳转修改页面
		request.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(request, response);
	}
	
	/**
	 * 跳转图书列表
	 * 带分页
	 */
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page<Book> page = WebUtils.param2Bean(request, new Page<Book>());
		// 查询图书分页信息
		page = bookService.queryBookPage(page);
		page.setUrl("BookManageServlet?action=page&");
		request.setAttribute("page", page);
		// 跳转到图书列表
		request.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(request, response);
	}
	
}
