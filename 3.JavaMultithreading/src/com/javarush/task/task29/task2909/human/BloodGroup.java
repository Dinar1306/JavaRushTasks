package com.javarush.task.task29.task2909.human;

public class BloodGroup {
    private final int code;

    private BloodGroup(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static BloodGroup first(){
        BloodGroup bg = new BloodGroup(1);
        return bg;
    }
    public static BloodGroup second(){
        BloodGroup bg = new BloodGroup(2);
        return bg;
    }
    public static BloodGroup third(){
        BloodGroup bg = new BloodGroup(3);
        return bg;
    }
    public static BloodGroup fourth(){
        BloodGroup bg = new BloodGroup(4);
        return bg;
    }

}
