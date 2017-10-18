package com.example.mybatis;

import com.example.mybatis.mapper.BookDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws Exception {
        String resource = "META-INF/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        sqlSessionFactory.getConfiguration().addMapper(BookDao.class);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            BookDao bookDao = session.getMapper(BookDao.class);
            Book book = bookDao.select(101);
            System.out.println(book);
        } finally {
            session.close();
        }
    }
}
