package com.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatisplus.dao.UserDao;
import com.mybatisplus.domain.User;
import com.mybatisplus.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    @Test
    void getAll(){
        // QueryWrapper<User> wrapper = new QueryWrapper();
        // wrapper.lt("age","10");
        // UserQuery uq = new UserQuery();
        // uq.setAge(15);
        // uq.setAge2(12);
        // LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        // lqw.lt(null!=uq.getAge2(),User::getAge,uq.getAge2());
        // lqw.gt(null!=uq.getAge(),User::getAge,uq.getAge());
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        // wrapper.select("id","name","age");
        wrapper.select("count(*) as nums,age");
        wrapper.groupBy("age");
        List<Map<String,Object>> list = userDao.selectMaps(wrapper);
        System.out.println(list);
    }
    @Test
    void Dql(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        // qw.lambda().eq(User::getName,"tom");
        // qw.lambda().eq(User::getPassword,"111");
        // qw.lambda().between(User::getAge,10,12);
        qw.lambda().like(User::getName,"%j%");
        List<User> users = userDao.selectList(qw);
        System.out.println(users);
    }

    @Test
    void delete(){
        List<Integer> list = Arrays.asList(new Integer[]{7,8,9});
        // List<Integer> list = new ArrayList<>();
        // list.add(7);
        // list.add(8);
        // list.add(9);
        userDao.deleteBatchIds(list);
    }
    @Test
    void deleteById(){
        userDao.deleteById(10);
    }

    @Test
    void Optimism(){
        User user = new User();
        user.setId(11);
        user.setAge(24);
        user.setName("田所");
        user.setPassword("114514");
        user.setTel("1919810");
        user.setVersion(0);
        userDao.updateById(user);
    }
    @Test
    void OpLock(){
        User user = userDao.selectById(11);
        User user2 = userDao.selectById(11);
        user.setName("浩二");
        user2.setName("浩二");
        System.out.println("user"+user);
        System.out.println("user2"+user2);
        userDao.updateById(user);
        userDao.updateById(user2);
    }
}
