package com.atguigu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.atguigu.bean.Order;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class OrderManageServlet
 */
public class OrderManageServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
       
	private OrderService orderService = new OrderServiceImpl();
	
	/**
	 * 跳转到订单列表页面
	 */
	protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> list = orderService.queryOrderList();
		request.setAttribute("list", list);
		// 转发到订单列表页面
		request.getRequestDispatcher("/pages/order/order.jsp").forward(request, response);
	}
	
	/**
	 * 发货
	 */
	protected void deliver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orderId = request.getParameter("orderId");
		orderService.updateOrder(orderId, 1);
		// 跳回到列表页面
		response.sendRedirect(request.getHeader("referer"));
	}

}
