package com.mybatis.service.impl;

import com.mybatis.dao.BookDao;
import com.mybatis.domain.Book;
import com.mybatis.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookDao bookDao;
    @Override
    public Book getById(int id) {
        return bookDao.findById(id);
    }
}
