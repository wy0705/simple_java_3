package com.ease.archiecture.other;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;


@ProcessorAnnotation(value = {
        P_StudentAgeProcessor.class,
        P_StudentNameProcessor.class
})
public class IfContentProcessor implements InitializingBean {

    private List<AbstractProcess> processorList = new ArrayList<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        ProcessorAnnotation annotation = getClass().getAnnotation(ProcessorAnnotation.class);
        if (annotation != null && annotation.value().length > 0) {
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext("");
            for (Class<? extends AbstractProcess> beanClass : annotation.value()) {
                AbstractProcess processor = (AbstractProcess) applicationContext.getBean(beanClass.getName());
                if (processor == null) {
                    throw new IllegalStateException("Bean " + beanClass.getName() + " not found");
                }
                processorList.add(processor);
            }
        }
    }

    public void process(SelfContext context) {
        if (context == null) {
            return;
        }
        for (AbstractProcess processor : processorList) {
            processor.process(context);
        }
        return;
    }
}
