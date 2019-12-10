package com.javarush.task.task27.task2712.statistic.event;

import com.javarush.task.task27.task2712.ad.Advertisement;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.javarush.task.task27.task2712.statistic.event.EventType.*;

public class VideoSelectedEventDataRow implements EventDataRow{
    public Date currentDate;
    private List<Advertisement> optimalVideoSet;
    private long amount;
    private int totalDuration;

    public long getAmount() {
        return amount;
    }

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration){
        this.currentDate = new Date();
        this.amount = amount;
        this.totalDuration = totalDuration;
        this.optimalVideoSet = optimalVideoSet;
    }

    @Override
    public EventType getType() {
        return SELECTED_VIDEOS;
    }

    @Override
    public Date getDate() {
        return new Date();
    }

    @Override
    public int getTime() {
        return (int)new Date().getTime();
    }
}
