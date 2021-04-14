package com.ease.archiecture.springannotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    @Autowired
    private Clazz clazz;

    public Clazz getClazz() {
        return clazz;
    }


    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void clazzPrint() {
        clazz.clazzPrint();
    }
}
