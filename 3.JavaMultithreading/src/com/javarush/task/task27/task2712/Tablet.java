package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import javafx.collections.ObservableArrayBase;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet extends Observable {
    private final int number; // это номер планшета, чтобы можно было однозначно установить, откуда поступил заказ
    public static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue<Order> queue;

    public Order createOrder(){
        Order order = null;
        try
        {
            order = new Order(this);
            ConsoleHelper.writeMessage(order.toString());
            setChanged(); //сразу после создания заказа и вывода информации о нем в консоль установить флаг setChanged()
            if (!order.isEmpty()) notifyObservers(order); //Отправить обсерверу заказ
            //Заказ готовится в то время, как видео смотрится.
            AdvertisementManager advManager = new AdvertisementManager(order.getTotalCookingTime()*60);
            advManager.processVideos();


            return order;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
            return null;
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + order);
            return null;
        }
    }

    public Tablet(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "of Tablet{number=" + number + "}";
    }



}
