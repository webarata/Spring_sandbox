package com.example.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/META-INF/application-context.xml");
        BookDao bookDao = ctx.getBean(BookDao.class);

        Book book = new Book(501, "はじめてのMyBatis", "バティスタ", 2500);
        System.out.println("挿入件数: " + bookDao.insert(book));

        System.out.println("=== 一覧の取得");
        bookDao.selectAll().forEach(System.out::println);
    }
}
