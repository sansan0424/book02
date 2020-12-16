package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

/**
 * 图书前台
 * @author Administrator
 *
 */
public class BookClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService bookService = new BookServiceImpl();
	
	protected void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Page<Book> page = WebUtils.param2Bean(request, new Page<Book>());
		String min = request.getParameter("min");
		String max = request.getParameter("max");
		
		// 查询图书分页信息
		page = bookService.queryBookPageByParam(page, min, max);
		page.setUrl("BookClientServlet?action=page&min="+min+"&max="+max+"&");
		request.setAttribute("page", page);
		// 跳转到首页图书列表
		request.getRequestDispatcher("/book_list.jsp").forward(request, response);
	}

}
