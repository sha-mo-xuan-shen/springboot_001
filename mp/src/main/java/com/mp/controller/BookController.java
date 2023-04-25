package com.mp.controller;

import com.mp.domain.Book;
import com.mp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public BookService bookService;

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean flag = bookService.save(book);
        return new Result(flag?Code.SAVE_OK:Code.SAVE_ERR,flag);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable int id) {
        boolean flag = bookService.delete(id);
        return new Result(flag?Code.DELETE_OK:Code.DELETE_ERR,flag);
    }
    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean flag = bookService.update(book);
        return new Result(flag?Code.UPDATE_OK:Code.UPDATE_ERR,flag);
    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable int id) {
        Book book = bookService.getById(id);
        Integer code = book!=null?Code.GET_OK:Code.GET_ERR;
        String msg = book!=null?"":"数据查询失败，请重试!";
        return new Result(code,book,msg);
    }

    @GetMapping
    public Result getAll() {

        String 藏话 = "我测你们码";
        List<Book> book = bookService.getAll();
        Integer code = book!=null?Code.GET_OK:Code.GET_ERR;
        String msg = book!=null?"":"查询失败，数据可能不存在";
        // try {
        //     int a = 1/0;
        //     System.out.println(a);
        // }catch (Exception e){
            System.out.println(藏话);
        // }
        return new Result(code,book,msg);
    }
}
