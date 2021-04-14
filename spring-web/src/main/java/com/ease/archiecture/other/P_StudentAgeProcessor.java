package com.ease.archiecture.other;

public class P_StudentAgeProcessor extends AbstractProcess {
    @Override
    protected void doProcess(SelfContext context) {
        System.out.println(context.getStudent().getAge());
    }
}
