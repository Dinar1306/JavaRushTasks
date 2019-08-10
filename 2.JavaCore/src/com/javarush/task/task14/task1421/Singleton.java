package com.javarush.task.task14.task1421;


/*
public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    private static class GetSingleton{
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return instance = GetSingleton.instance;
    }
}
*/

public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}