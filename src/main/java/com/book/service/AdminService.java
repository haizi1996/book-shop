package com.book.service;

import com.book.model.Admin;
import com.book.model.Book;
import com.book.model.BookDetail;
import com.book.model.Category;

import java.util.List;

public interface AdminService {

    List<BookDetail> getAllBook(Integer pageNum , Integer pageSize);

    Integer addBook(Book book);




    List<Category> getAllCategories();
    Integer addCategory(Category category);


    Integer login(Admin admin);
}
