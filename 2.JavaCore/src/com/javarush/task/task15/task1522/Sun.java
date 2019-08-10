package com.javarush.task.task15.task1522;

public class Sun implements Planet{
    private static Sun instance;
    private Sun(){}
    private static class GetSun{
        private static final Sun instance = new Sun();
    }
    public static Sun getInstance(){
        return instance = GetSun.instance;
    }
}
