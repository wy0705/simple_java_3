package com.ease.archiecture.springdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DITestMain {

    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("DIBeansTest.xml");
        DITestEntity te = (DITestEntity) context.getBean("diTestEntity");
        te.justPrint();
    }
}
