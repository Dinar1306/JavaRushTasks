package com.javarush.task.task27.task2712.statistic.event;

import java.util.Calendar;
import java.util.Date;

import static com.javarush.task.task27.task2712.statistic.event.EventType.*;

public class NoAvailableVideoEventDataRow implements EventDataRow{

    private final Date currentDate;
    private int totalDuration;

    public NoAvailableVideoEventDataRow(int totalDuration){
        this.currentDate = new Date();
        this.totalDuration = totalDuration;
    }

    @Override
    public EventType getType() {
        return NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate() {
        return new Date();
    }

    @Override
    public int getTime() {
        return (int) new Date().getTime();
    }
    //totalDuration - время приготовления заказа в секундах
}
