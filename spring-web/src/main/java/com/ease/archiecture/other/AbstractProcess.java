package com.ease.archiecture.other;

public abstract class AbstractProcess<T extends SelfContext> {

    final public void process(T context) {
        if (context == null) {
            return;
        }
        doProcess(context);

    }

    abstract protected void doProcess(T context);
}
