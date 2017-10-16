package com.example.mybatis;

import com.example.mybatis.mapper.BookDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/META-INF/application-context.xml");
        BookDao bookDao = ctx.getBean(BookDao.class);

        System.out.println("=== book_id=101");
        System.out.println(bookDao.select(101));

        System.out.println("    book_id=103");
        System.out.println(bookDao.select(103));

        System.out.println("=== 一覧の取得");
        bookDao.selectAll().forEach(System.out::println);
    }
}
