package com.book.dao;

import com.book.BaseTest;
import com.book.model.Book;
import com.book.model.BookDetail;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookDaoTest extends BaseTest{
    static {
        logger = LoggerFactory.getLogger(BookDao.class);
    }



    @Autowired
    private BookDao bookDao;

    @Test
    public void addBookTest(){

        Book book = new Book();

        book.setImageUrl("/sss");
        book.setCategoryId(6);
        book.setDescription("ddd");
        book.setPrice(12);
        book.setNum(12);
        book.setName("xiyouji");
        Integer num = bookDao.addBook(book);
        System.out.println(num);

    }


    @Test
    public void listBooks(){

        List<BookDetail> books = bookDao.query();

        for (BookDetail book : books) {
            System.out.println(book.toString());
        }

    }
}
