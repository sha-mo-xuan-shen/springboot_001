package com.frog.test.service.impl;

import com.frog.test.service.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Override
    public void save() {
        System.out.println("奥利安费");
    }
}
