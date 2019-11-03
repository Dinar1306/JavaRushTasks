package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 *
 */
public class Waiter extends Observable implements Observer {
    /**
     //* @param o  объект, который отправил нам значение - Cook
     //* @param arg само значение - Order
     */
    @Override
    public void update(Observable cook, Object order){
        ConsoleHelper.writeMessage(order + " was cooked by " + cook);
//        setChanged();
//        notifyObservers(order);
    }
}
