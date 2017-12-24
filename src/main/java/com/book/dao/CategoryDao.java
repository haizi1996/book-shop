package com.book.dao;

import com.book.model.Category;

import java.util.List;


public interface CategoryDao {

	//void addCategory(Category c);

	List<Category> findAll() throws Exception;

	//Category findCatetoryById(Integer categoryId);
}
