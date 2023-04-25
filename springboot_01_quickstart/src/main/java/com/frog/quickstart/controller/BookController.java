package com.frog.quickstart.controller;


import com.frog.quickstart.domain.EnterPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Value("${lesson}")
    String lesson;
    @Value("${enterprice.subject[0]}")
    String name;

    @Autowired
    Environment environment;

    @Autowired
    EnterPrice enterPrice;
    @GetMapping("/{id}")
    public String getById(@PathVariable int id){
        System.out.println(id);
        System.out.println(lesson);
        System.out.println(name);
        System.out.println(environment.getProperty("enterprice.subject[1]"));
        System.out.println(enterPrice);
        return "小毕宰治输了个"+id;
    }
}
