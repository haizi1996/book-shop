package com.book.service;

import com.book.model.BookDetail;
import com.book.model.Category;
import com.book.model.User;

import java.util.List;

public interface ClientService {

    List<BookDetail>  getPageNumBook(Integer pageNum , Integer pageSize);


    Integer getTotalRecords();


    User login(User user);


    Integer regist(User user);

    BookDetail getBookDetailById(Integer id);

    List<Category>  findAllCategory();
}
