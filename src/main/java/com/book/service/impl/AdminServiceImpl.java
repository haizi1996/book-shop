package com.book.service.impl;


import com.book.dao.AdminDao;
import com.book.dao.BookDao;
import com.book.dao.CategoryDao;
import com.book.dao.UserDao;
import com.book.model.Admin;
import com.book.model.Book;
import com.book.model.BookDetail;
import com.book.model.Category;
import com.book.service.AdminService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private BookDao bookDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private CategoryDao categoryDao;

    @Resource
    private AdminDao adminDao;

    private static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    public List<BookDetail> getAllBook(Integer pageNum, Integer pageSize) {
        pageNum = pageNum < 1 ? 1 : pageNum;
        PageHelper.startPage(pageNum,pageSize);
        return bookDao.query();
    }

    public List<Category> getAllCategories() {
        try {
            return categoryDao.findAll();
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public Integer addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public Integer addCategory(Category category){
        try {
            return categoryDao.addCategory(category);
        }catch (Exception e){
            LOGGER.error(e.getMessage());
            return -1;
        }
    }

    @Override
    public Integer login(Admin admin) {
        return adminDao.login(admin);
    }
}
