package com.ease.archiecture.other;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProcessorAnnotation {

    Class<? extends AbstractProcess>[] value();
}
