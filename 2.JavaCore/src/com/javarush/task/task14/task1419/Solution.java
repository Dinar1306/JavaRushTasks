package com.javarush.task.task14.task1419;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
Заполни список exceptions десятью(10) различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Требования:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код
        try {
            exceptions.remove(5);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            Exception e = new Exception();
            throw new TypeNotPresentException("5", e);
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new SecurityException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new NegativeArraySizeException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalMonitorStateException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalArgumentException();
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ClassNotFoundException();
        } catch (Exception e) {
            exceptions.add(e);
        }


    }
}
