package com.ease.archiecture.other;

import com.ease.archiecture.webcore.entity.Student;

abstract class SelfContext {
    //do your param thing
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
