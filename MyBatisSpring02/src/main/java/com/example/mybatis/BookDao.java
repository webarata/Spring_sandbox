package com.example.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    @Select("SELECT * FROM book WHERE book_id = #{bookId}")
    public Book select(@Param("bookId") Integer bookId);

    @Select("SELECT * FROM book")
    public List<Book> selectAll();

    @Insert("INSERT INTO book VALUES(#{bookId}, #{bookName}, #{author}, #{price})")
    public int insert(Book book);

    @Update("UPDATE book SET price=#{price} WHERE book_id = #{bookId}")
    public int update(Book book);
}
