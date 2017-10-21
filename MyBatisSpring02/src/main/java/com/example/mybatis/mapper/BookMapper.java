package com.example.mybatis.mapper;

import com.example.mybatis.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface BookMapper {
    public Book select(@Param("bookId") Integer bookId);
}
