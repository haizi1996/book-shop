package com.book.dao;

import com.book.model.Category;

import java.util.List;


public interface CategoryDao {

	Integer addCategory(Category c) throws Exception;

	List<Category> findAll() ;

	//Category findCatetoryById(Integer categoryId);
}
