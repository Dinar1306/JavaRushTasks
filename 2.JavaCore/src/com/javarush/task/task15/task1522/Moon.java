package com.javarush.task.task15.task1522;

public class Moon implements Planet{
    private static Moon instance;
    private Moon(){}
    private static class GetMoon{
        private static final Moon instance = new Moon();
    }
    public static Moon getInstance(){
        return instance = GetMoon.instance;
    }
}
