package com.example.mybatis;

import com.example.mybatis.mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream is = Main.class.getResourceAsStream("/config.properties")) {
            properties.load(is);
        }

        SqlSessionFactory sqlSessionFactory;
        try (InputStream is = Main.class.getResourceAsStream("/META-INF/mybatis-config.xml")) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is, "development", properties);
        }

        try (SqlSession session = sqlSessionFactory.openSession()) {
            Book book = new Book(300, "テスト", "test", 3000);
            session.insert("com.example.mybatis.mapper.BookMapper.insert", book);
            session.commit();
        }
    }
}
