package com.ease.archiecture.other;

public class P_StudentNameProcessor extends AbstractProcess {
    @Override
    protected void doProcess(SelfContext context) {
        System.out.println(context.getStudent().getName());
    }
}
