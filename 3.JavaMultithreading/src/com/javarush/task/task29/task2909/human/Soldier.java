package com.javarush.task.task29.task2909.human;

public class Soldier extends Human /*implements Alive*/{

    private int bloodGroup;
    private boolean isSoldier;

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void live() {
        fight();
    }

    public void fight() {
    }
}
