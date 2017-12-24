package com.book.dao;


import com.book.model.Orders;
import com.book.model.User;

public interface OrdersDao {
	void addOrders(Orders orders, User user);
}
