package com.book.service;

import com.book.model.Book;
import com.book.model.Category;

import java.util.List;

public interface AdminService {

    List<Book> getAllBook(Integer pageNum , Integer pageSize);

    List<Category> getAllCategories();

    Integer addBook(Book book);

}
