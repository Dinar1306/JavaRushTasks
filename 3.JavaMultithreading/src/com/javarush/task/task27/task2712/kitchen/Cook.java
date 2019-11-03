package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import javafx.beans.InvalidationListener;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable implements Observer {
    String name;

    @Override
    public String toString() {
        return name;
    }

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        //Order order = (Order) arg;
        Object order =  arg;
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time " + ((Order)arg).getTotalCookingTime() + "min");
        //Expected output: Start cooking - Your order: [Soup] of Tablet{number=5}
        //ConsoleHelper.writeMessage(order + " was cooked by " + name);
        setChanged();
        notifyObservers(order);
    }
}
