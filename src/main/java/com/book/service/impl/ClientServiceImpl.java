package com.book.service.impl;

import com.book.dao.BookDao;
import com.book.model.BookDetail;
import com.book.model.User;
import com.book.service.ClientService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Resource
    private BookDao bookDao;

    @Override
    public List<BookDetail> getPageNumBook(Integer pageNum , Integer pageSize) {
        PageHelper.startPage(pageNum , pageSize);
        return bookDao.query();
    }

    @Override
    public Integer getTotalRecords() {
        return bookDao.getTotalRecord();
    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public Integer regist(User user) {
        return null;
    }
}
