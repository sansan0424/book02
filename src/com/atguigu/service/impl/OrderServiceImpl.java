package com.atguigu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.atguigu.bean.Book;
import com.atguigu.bean.Cart;
import com.atguigu.bean.CartItem;
import com.atguigu.bean.Order;
import com.atguigu.bean.OrderItem;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.service.BookService;
import com.atguigu.service.OrderItemService;
import com.atguigu.service.OrderService;

public class OrderServiceImpl implements OrderService{

	private OrderDao orderDao = new OrderDaoImpl();
	
	private OrderItemService orderItemService = new OrderItemServiceImpl();
	
	private BookService bookService = new BookServiceImpl();
	
	@Override
	public String saveOrder(Cart cart, Integer userId) {
		//1）生成订单号
		// 时间戳+用户编号拼接
		String orderId = System.currentTimeMillis()+userId+"";
		//2）订单详情（总价，日期，状态）
		Order order = new Order(orderId, cart.getTotalMoney(), 0, userId);
		orderDao.insertOrder(order);
		//3）保存订单项
		List<OrderItem> items = new ArrayList<OrderItem>();
		for (CartItem cItem : cart.getItems()) {
			items.add(new OrderItem(cItem.getBook().getTitle(), cItem.getBook().getPrice(), cItem.getCount(), cItem.getTotalPrice(), orderId));
		}
		orderItemService.saveOrderItemBatch(items);
		//4）修改库存及销量
		Book book = null;
		for (CartItem cItem : cart.getItems()) {
			book = bookService.queryBook(cItem.getBook());
			bookService.updateSalesAndStock(new Book(book.getId(), book.getSales()+cItem.getCount(), book.getStock()-cItem.getCount()));
		}
		return orderId;
	}

	@Override
	public void updateOrder(String orderId, int status) {
		Order order = new Order();
		order.setOrderId(orderId);
		order.setStatus(status);
		orderDao.updateStatus(order);
	}

	@Override
	public List<Order> queryOrderList() {
		return orderDao.getOrderList();
	}

	@Override
	public List<Order> queryOrderListByUserId(Integer userId) {
		return orderDao.getOrderListByUserId(userId);
	}

}
