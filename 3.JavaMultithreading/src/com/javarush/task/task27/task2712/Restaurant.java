package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws Exception {
        Tablet tablet = new Tablet(5);
//        tablet1.createOrder();
//        tablet1.createOrder();
//        tablet1.createOrder();
        Cook firstCook = new Cook("Mumamba");
        tablet.addObserver(firstCook);
        tablet.createOrder();
        Waiter oficiant = new Waiter();
        firstCook.addObserver(oficiant);
    }
}
