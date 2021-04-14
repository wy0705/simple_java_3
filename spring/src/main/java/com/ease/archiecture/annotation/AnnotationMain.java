package com.ease.archiecture.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("AnnotationTest.xml");
        Company company = applicationContext.getBean("company", Company.class);
        company.getUserName();
    }
}
