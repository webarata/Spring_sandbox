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
        String resource = "META-INF/mybatis-config.xml";
        InputStream is = Resources.getResourceAsStream(resource);

        InputStream isProp = Resources.getResourceAsStream("config.properties");
        Properties properties = new Properties();
        properties.load(isProp);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is, "development", properties);

        try (SqlSession session = sqlSessionFactory.openSession()) {
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            Book book = bookMapper.select(101);

            Book book2 = new Book(300, "テスト", "test", 3000);
            session.insert("com.example.mybatis.mapper.BookMapper.insert", book2);
            session.commit();
        }
    }
}
