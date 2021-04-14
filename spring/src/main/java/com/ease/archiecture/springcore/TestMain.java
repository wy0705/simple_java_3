package com.ease.archiecture.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeansTest.xml");
        TestEntity testEntity = (TestEntity) applicationContext.getBean("testEntity");
        System.out.println(testEntity.getMsg());

    }
}
