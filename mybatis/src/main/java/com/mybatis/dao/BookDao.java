package com.mybatis.dao;

import com.mybatis.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

// @Repository
@Mapper
public interface BookDao {
    @Select("select * from book where id=#{id}")
    public Book findById(int id);
}
