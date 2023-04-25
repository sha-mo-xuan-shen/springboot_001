package com.mp.dao;

import com.mp.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

// @Repository
@Mapper
public interface BookDao {

    // @Insert("insert into book values (null,#{type},#{name},#{description})")
    @Insert("insert into book (type,name,description)values(#{type},#{name},#{description})")
    public int save(Book book);
    @Delete("delete from book where id=#{id}")
    public int delete(int id);
    @Update("update book set type=#{type},name=#{name},description=#{description} where id = #{id}")
    public int update(Book book);
    @Select("select * from book where id=#{id}")
    public Book getById(int id);
    @Select("select * from book")
    public List<Book> getAll();
}
