package com.book.dao;

import com.book.BaseTest;
import com.book.model.Category;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryDaoTes extends BaseTest {

    @Autowired
    private CategoryDao categoryDao;

    static {
        logger = LoggerFactory.getLogger(CategoryDao.class);
    }

    @Test
    public void findAll() throws Exception{
        List<Category> categories = categoryDao.findAll();

        categories.forEach(category -> logger.info(category.toString()));
    }


}
