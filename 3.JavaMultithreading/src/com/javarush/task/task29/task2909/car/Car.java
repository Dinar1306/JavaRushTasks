package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    static public final int MAX_TRUCK_SPEED = 80;
    static public final int MAX_SEDAN_SPEED = 120;
    static public final int MAX_CABRIOLET_SPEED = 90;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    private boolean canPassengersBeTransferred(){
        return isDriverAvailable() & (fuel>0);
    }

    public static Car create(int type, int numberOfPassengers){
        Car c = null;
        switch (type){
            case 0: {
                c = new Truck(type, numberOfPassengers);
                break;
            }
            case 1: {
                c = new Sedan(type, numberOfPassengers);
                break;
            }
            case 2: {
                c = new Cabriolet(type, numberOfPassengers);
                break;
            }
        }
        return c;
    }

    public void fill(double numberOfLiters) throws Exception{
        if (numberOfLiters < 0){
            throw new Exception();
            //return -1;
        }
        fuel += numberOfLiters;
        //return 0;
    }

    public boolean isSummer(Date date, Date summerStart, Date summerEnd){
        if (date.after(summerStart) & date.before(summerEnd)){
            return true;
        } else return false;
    }

    public double getWinterConsumption(int length){
        return length*winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return length*summerFuelConsumption;
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (!isSummer(date, SummerStart, SummerEnd)) {
            //consumption = length * winterFuelConsumption + winterWarmingUp;
            consumption = getWinterConsumption(length);
        } else {
            //consumption = length * summerFuelConsumption;
            consumption = getSummerConsumption(length);
        }
        return consumption;
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed() ;
//    {
//        if (type == TRUCK)
//            return MAX_TRUCK_SPEED;
//        if (type == SEDAN)
//            return MAX_SEDAN_SPEED;
//        return MAX_CABRIOLET_SPEED;
//    }
}