package com.example.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/META-INF/application-context.xml");
        BookDao bookDao = ctx.getBean(BookDao.class);

        System.out.println(bookDao.selectBook(101));
    }
}
