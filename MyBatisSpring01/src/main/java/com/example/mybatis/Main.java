package com.example.mybatis;

import com.example.mybatis.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "META-INF/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            Book book = bookMapper.select(101);
        }
    }
}
