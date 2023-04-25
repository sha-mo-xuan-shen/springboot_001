package com.mp;

import com.mp.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MpApplicationTests {

    @Autowired
    BookService bookService;
    @Test
    void contextLoads() {
        System.out.println(bookService.getAll());
    }

}
