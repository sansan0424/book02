package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Cart;
import com.atguigu.bean.Order;
import com.atguigu.bean.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import com.atguigu.utils.WebUtils;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderClientServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService orderService = new OrderServiceImpl();
	
	/**
	 * 结算，生成订单编号
	 */
	protected void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = WebUtils.getCart(request);
		User user = WebUtils.getUser(request);
		String orderId = orderService.saveOrder(cart, user.getId());
		request.setAttribute("orderId", orderId);
		// 清空购物车
		cart.clear();
		// 转发到结算成功页面
		request.getRequestDispatcher("/pages/cart/checkout.jsp").forward(request, response);
	}

	/**
	 * 跳转到订单列表
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = WebUtils.getUser(request);
		List<Order> list = orderService.queryOrderListByUserId(user.getId());
		request.setAttribute("list", list);
		// 转发到订单列表页面
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	/**
	 * 确认收货
	 */
	protected void receive(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		orderService.updateOrder(orderId, 2);
		// 跳回到列表页面
		response.sendRedirect(request.getHeader("referer"));
	}
	
}
