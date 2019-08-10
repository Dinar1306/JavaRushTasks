package com.javarush.task.task09.task0902;

/* 
И снова StackTrace
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        method1();
        //System.out.println(method1());
    }

    public static String method1() {
        method2();
        //напишите тут ваш код
        //String s = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
         String s = stackTraceElements[2].getMethodName();
         System.out.println(s);
         return s;
    }

    public static String method2() {
        method3();
        //напишите тут ваш код
        //String s = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
         String s = stackTraceElements[2].getMethodName();
         System.out.println(s);
         return s;
    }

    public static String method3() {
        method4();
        //напишите тут ваш код
        //String s = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
         String s = stackTraceElements[2].getMethodName();
         System.out.println(s);
         return s;
    }

    public static String method4() {
        method5();
        //напишите тут ваш код
        //String s = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
         String s = stackTraceElements[2].getMethodName();
         System.out.println(s);
         return s;
    }

    public static String method5() {
        //напишите тут ваш код
        //String s = "";
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
         String s = stackTraceElements[2].getMethodName();
         System.out.println(s);
         return s;
    }
}
