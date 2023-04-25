package com.mp.service.impl;

import com.mp.controller.Code;
import com.mp.dao.BookDao;
import com.mp.domain.Book;
import com.mp.exception.SystemException;
import com.mp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    public boolean save(Book book) {
        return bookDao.save(book) > 0;
    }

    public boolean delete(int id) {

        return bookDao.delete(id)>0;
    }

    public boolean update(Book book) {

        return bookDao.update(book)>0;
    }

    public Book getById(int id) {

        // if(id==1){
        //     throw new BussinessException(Code.BUSSINESS_ERR,"找不到1");
        // }
        try {
            // int i = 1/0;
        }catch (Exception e){
            throw new SystemException(Code.SYSTEM_TIMEOUT,"查询失败，访问超时");
        }
        return bookDao.getById(id);

    }

    public List<Book> getAll() {

        try {
            // int i = 1/0;
        }catch (ArithmeticException e){
            throw new SystemException(Code.SYSTEM_ERR,"查询失败，请重试",e);
        }
        List<Book> all = bookDao.getAll();
        return all;
    }
}
