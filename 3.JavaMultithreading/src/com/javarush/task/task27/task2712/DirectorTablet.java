package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double totalAmount = 0;
        for (Map.Entry<Date, Double> profitOfDay : StatisticManager.getInstance().getAdvertisementProfit().entrySet()) {
            Date date = profitOfDay.getKey();
            Double amount = profitOfDay.getValue();
            totalAmount += amount;
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", sdf.format(date), amount));
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", totalAmount));

    }
    public void printCookWorkloading() {
        Map<String, Map<String, Integer>> statMap = StatisticManager.getInstance().getCookWorkloading();
        for (Map.Entry<String, Map<String, Integer>> entryMap : statMap.entrySet())
        {

            for (Map.Entry<String, Integer> entry : entryMap.getValue().entrySet())
            {
                //Выводим дату
                ConsoleHelper.writeMessage(entryMap.getKey());
                //Выводим повара
                String cookName = entry.getKey();
                int workTime = (int) Math.ceil(entry.getValue()/60.0);
                ConsoleHelper.writeMessage(String.format("%s - %d min", cookName, workTime));
            }
        }
    }
    void printActiveVideoSet(){//список активных роликов и оставшееся количество показов по каждому

    }
    void printArchivedVideoSet(){//список неактивных роликов (с оставшемся количеством показов равным нулю).

    }
}
