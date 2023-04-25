package com.mybatisplus;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.dao.UserDao;
import com.mybatisplus.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    UserDao userDao;
    @Test
    void contextLoads() {
        User user = userDao.selectById(1);
        System.out.println(user);
    }
    @Test
    void testGetAll(){
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    @Test
    void save(){
        User user = new User();
        user.setAge(10);
        user.setName("jerry");
        user.setPassword("aiyaminuo");
        user.setTel("1919810");
        userDao.insert(user);
    }

    @Test
    void testByPage(){
        IPage page = new Page(1,2);
        userDao.selectPage(page,null);
        System.out.println("当前页数:"+page.getCurrent());
        System.out.println("当前显示数:"+page.getSize());
        System.out.println("总页数:"+page.getPages());
        System.out.println("总数据:"+page.getTotal());
        // System.out.println(page.getRecords());
    }
}
