package com.example.mybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BookDao {
    @Select("SELECT * FROM book WHERE book_id = #{bookId}")
    Book selectBook(@Param("bookId") Integer bookId);
}
