package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car{
    public Cabriolet(int type, int numberOfPassengers) {
        super(type, numberOfPassengers);
    }
    public Cabriolet(int numberOfPassengers) {
        super(0, numberOfPassengers);
    }
    @Override
    public int getMaxSpeed() {
        return super.MAX_CABRIOLET_SPEED;
    }

}
