package com.ease.archiecture.springcore;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringLife {


    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeansTest.xml");
        TestEntity obj = (TestEntity) context.getBean("exampleBean");
        obj.setMsg("aaaaaaa");
        System.out.println(obj.getMsg());
        context.registerShutdownHook();
    }
}
