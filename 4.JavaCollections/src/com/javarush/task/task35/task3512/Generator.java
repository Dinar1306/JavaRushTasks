package com.javarush.task.task35.task3512;

import java.lang.reflect.ParameterizedType;

public class Generator<T> {
    public Class<T> cls;

    public Generator(Class<T> cls) {
        this.cls = cls;
    }

//    public Generator() {
//        Generator<T> gen = new Class<T>();
//    }

    T newInstance() throws IllegalAccessException, InstantiationException {

//        ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
//        Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];

        return cls.newInstance();
    }
}
