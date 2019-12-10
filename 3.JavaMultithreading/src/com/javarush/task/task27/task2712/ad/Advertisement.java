package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.NoAvailableVideoEventDataRow;

public class Advertisement {
    Object content; // видео
    String name; // имя/название
    long initialAmount; // начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
    int hits; // количество оплаченных показов
    long amountPerOneDisplaying; //должно равняться стоимости одного показа рекламного объявления в копейках (initialAmount/hits).
    int duration; // продолжительность в секундах

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        //this.amountPerOneDisplaying = initialAmount/hits;
        this.amountPerOneDisplaying = (hits > 0) ? initialAmount / hits : 0;
        //initialAmount / hits; а не this.amountPerOneDisplaying = initialAmount/hits;
    }

    public void revalidate() throws UnsupportedOperationException {
        if (getHits() <= 0){
            //throw new UnsupportedOperationException();
            StatisticManager.getInstance().register(new NoAvailableVideoEventDataRow(duration));
            throw new NoVideoAvailableException();
        }
        hits--;
    }


    //геттеры для полей name, duration и amountPerOneDisplaying
    public String getName() {
        return name;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public int getDuration() {
        return duration;
    }

    public int getHits()
    {
        return hits;
    }
}
