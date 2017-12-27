package com.book.dao;

import com.book.model.Category;

import java.util.List;


public interface CategoryDao {

	Integer addCategory(Category c) throws Exception;

	List<Category> findAll() throws Exception;

	//Category findCatetoryById(Integer categoryId);
}
