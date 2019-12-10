package com.javarush.task.task38.task3810;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.ANNOTATION_TYPE)
public @interface Date {
    int year();

    short month();

    short day();

    short hour();

    short minute();

    short second();
}
