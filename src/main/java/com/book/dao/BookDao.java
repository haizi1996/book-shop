package com.book.dao;

import com.book.model.Book;
import com.book.model.BookDetail;

import java.util.List;

public interface BookDao {

    List<BookDetail> query();
    Integer addBook( Book book);
    int getTotalRecord();//查询所有的记录条数
    int getTotalRecord(String categoryId);
    List findPageBooks(int startindex, int pagesize, String categoryId);
    BookDetail findBookById(Integer bookId);
}
