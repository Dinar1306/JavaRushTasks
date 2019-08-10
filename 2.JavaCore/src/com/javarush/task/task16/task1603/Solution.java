package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити

В методе main добавить в статический объект list 5 нитей. Каждая нить должна быть новым объектом класса Thread, работающим со своим объектом класса SpecialThread.
Требования:
1. В методе main создай 5 объектов типа SpecialThread.
2. В методе main создай 5 объектов типа Thread.
3. Добавь 5 разных нитей в список list.
4. Каждая нить из списка list должна работать со своим объектом класса SpecialThread.
5. Метод run класса SpecialThread должен выводить "it's a run method inside SpecialThread".
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        //Add your code here - добавьте свой код тут

        SpecialThread sNit1 = new SpecialThread();
        SpecialThread sNit2 = new SpecialThread();
        SpecialThread sNit3 = new SpecialThread();
        SpecialThread sNit4 = new SpecialThread();
        SpecialThread sNit5 = new SpecialThread();

        Thread nit1 = new Thread(sNit1);
        Thread nit2 = new Thread(sNit2);
        Thread nit3 = new Thread(sNit3);
        Thread nit4 = new Thread(sNit4);
        Thread nit5 = new Thread(sNit5);
/*
        nit1.start();
        nit2.start();
        nit3.start();
        nit4.start();
        nit5.start();*/

        list.add(nit1);
        list.add(nit2);
        list.add(nit3);
        list.add(nit4);
        list.add(nit5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
