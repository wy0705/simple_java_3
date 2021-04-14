package com.ease.archiecture;

import com.ease.archiecture.entity.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestConstructor {

    public static void main(String[] args) {
        User u = null;
        User u1 = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("ConstructorTest.xml");
        u = (User) context.getBean("user");
        u1 = (User) context.getBean("user");
        System.out.println(u.getUsername());
        System.out.println(u1.getUsername());
    }
}
