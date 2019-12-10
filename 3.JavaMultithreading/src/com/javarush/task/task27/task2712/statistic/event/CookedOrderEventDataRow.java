package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CookedOrderEventDataRow implements EventDataRow{
    private final Date currentDate;
    private String tabletName;
    private String cookName;
    private int cookingTimeSeconds;
    private List<Dish> cookingDishs;

    public String getCookName() {
        return cookName;
    }

    public CookedOrderEventDataRow(String tabletName, String cookName, int cookingTimeSeconds, List<Dish> cookingDishs){
        this.currentDate = new Date();
        this.cookingDishs = cookingDishs;
        this.cookingTimeSeconds = cookingTimeSeconds;
        this.cookName = cookName;
        this.tabletName = tabletName;
    }

    @Override
    public EventType getType() {
        return EventType.COOKED_ORDER;
    }

    @Override
    public Date getDate() {
        return new Date();
    }

    @Override
    public int getTime() {
        return (int) new Date().getTime();
    }
//    tabletName - имя планшета
//    cookName - имя повара
//    cookingTimeSeconds - время приготовления заказа в секундах
//    cookingDishs - список блюд для приготовления
}
