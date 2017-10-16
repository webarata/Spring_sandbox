package com.example.mybatis.mapper;

import com.example.mybatis.Book;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookDao {
    @Select("SELECT * FROM book WHERE book_id = #{bookId}")
    public Book select(@Param("bookId") Integer bookId);

    @Select("SELECT * FROM book")
    public List<Book> selectAll();
}
