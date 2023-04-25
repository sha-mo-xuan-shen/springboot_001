package com.frog.test1;

import com.frog.test.TestApplication;
import com.frog.test.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestApplication.class)
class TestApplicationTests {

    @Autowired
    BookService bookService;

    @Test
    void contextLoads() {
        bookService.save();
    }

}
