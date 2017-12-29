package com.book.dao;


import com.book.model.User;

public interface UserDao {

	void addUser(User user);

	User login(User user);

}
