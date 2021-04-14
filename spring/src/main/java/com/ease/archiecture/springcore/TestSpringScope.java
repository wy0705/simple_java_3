package com.ease.archiecture.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringScope {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("BeansTest.xml");
        TestEntity testEntity = (TestEntity) applicationContext.getBean("testEntity1");
        testEntity.setMsg("Object A");
        System.out.println(testEntity.getMsg());
        TestEntity testEntity1 = (TestEntity) applicationContext.getBean("testEntity1");
        System.out.println(testEntity1.getMsg());
    }
}
