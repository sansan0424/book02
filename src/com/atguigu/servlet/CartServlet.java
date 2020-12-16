package com.atguigu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

/**
 * 购物车
 * @author Administrator
 *
 */
public class CartServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private BookService bookService = new BookServiceImpl();
	/**
	 * 加入购物车
	 */
	protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2Bean(request, new Book());
		// 从session中获取购物车
		Cart cart = WebUtils.getCart(request);
		cart.addBook2Cart(book);
		// 最后加购商品名称
		book = bookService.queryBook(book);
		request.getSession().setAttribute("lastAddCart", book.getTitle());
		// 跳回列表页面
		response.sendRedirect(request.getHeader("referer"));
	}

	/**
	 * 从购物车中删除购物项
	 */
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2Bean(request, new Book());
		// 从session中获取购物车
		Cart cart = WebUtils.getCart(request);
		cart.deleteItem(book);
		// 跳回购物车页面
		response.sendRedirect(request.getHeader("referer"));
	}
	
	/**
	 * 更改购物车中购物项数量
	 */
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Book book = WebUtils.param2Bean(request, new Book());
		int count = Integer.parseInt(request.getParameter("count"));
		// 从session中获取购物车
		Cart cart = WebUtils.getCart(request);
		cart.updateCount(book, count);
		// 跳回购物车页面
		response.sendRedirect(request.getHeader("referer"));
	}
	
	/**
	 * 清空购物车
	 */
	protected void clear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 从session中获取购物车
		Cart cart = WebUtils.getCart(request);
		cart.clear();
		request.getSession().removeAttribute("lastAddCart");
		// 跳回购物车页面
		response.sendRedirect(request.getHeader("referer"));
	}
	
}
