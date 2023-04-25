package com.mybatis;

import com.mybatis.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    BookService bookService;

    @Test
    void contextLoads() {
        System.out.println(bookService.getById(1));
        bookService.getById(2);
    }

}
