package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StatisticManager {
    //1. Создадим пакет statistic, в котором создадим класс StatisticManager. С его помощью будем регистрировать события в хранилище.
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();

    //Создай в классе StatisticManager множество (Set) поваров (cooks) и добавь в него повара.
    public Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data){
        //5. В StatisticManager создадим публичный метод void register(EventDataRow data),
        // который будет регистрировать событие в хранилище.
        //Хранилище связано 1 к 1 с менеджером, т.е. один менеджер и одно хранилище на приложение.
        //К хранилищу может доступиться только StatisticManager. Поэтому...
        //Из вышеперечисленного следует, что хранилище должно быть приватным иннер классом.
        //Назовем его StatisticStorage.
        statisticStorage.put(data);
    }

    //Вычисляет статистику по загрузке поваров
    public Map<String, Map<String, Integer>> getCookWorkloading()
    {
        //Получаем список данных из хранилища
        List<EventDataRow> cookedOrders = statisticStorage.getAllRowsOfType(EventType.COOKED_ORDER);
        //Объект для форматирования даты
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        //Создаем карту, в которую будем складывать результаты
        //Группировка по дате, вторая группировка по повару.
        Map<String, Map<String, Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow cookedOrder : cookedOrders)
        {
            //Приводим запись события в нужную форму
            CookedOrderEventDataRow orderRow = (CookedOrderEventDataRow) cookedOrder;
            //Получаем дату из записи
            String dateKey = simpleDateFormat.format(orderRow.getDate());
            //Получаем имя повара
            String cookName = orderRow.getCookName();
            //Получаем время работы повара
            Integer workTime = orderRow.getTime();
            //Если время > 0, то обрабатываем запись.
            //Если запись с датой уже есть
            if (workTime > 0) {
                if (resultMap.containsKey(dateKey))
                {
                    //Получаем все записи с этой датой
                    Map<String, Integer> cooks = resultMap.get(dateKey);
                    //Если запись с поваром уже есть
                    if (cooks.containsKey(cookName))
                    {
                        //Обновляем запись с новой суммой времени
                        cooks.put(cookName, cooks.get(cookName) + orderRow.getTime());
                    }
                    else
                    {
                        //Иначе добавляем нового повара
                        cooks.put(cookName, orderRow.getTime());
                    }
                }
                else {
                    //Если записи с датой нет, то добавляем новую запись
                    resultMap.put(dateKey, new TreeMap<>());
                    resultMap.get(dateKey).put(cookName, orderRow.getTime());
                }
            }
        }
        return resultMap;
    }

    public Map<Date,Double> getAdvertisementProfit() {
        List<EventDataRow> eventDataRowList = statisticStorage.getEventsByType(EventType.SELECTED_VIDEOS);


        Map<Date,Double> result = new TreeMap<>(Collections.reverseOrder());
        Date dateWithOutTime;
        Calendar calendar;
        double amount;

        for( EventDataRow eventDataRow : eventDataRowList) {

            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            amount = videoSelectedEventDataRow.getAmount()/100.0;



            calendar = Calendar.getInstance();
            calendar.setTime(videoSelectedEventDataRow.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            dateWithOutTime = gc.getTime();

            if (result.containsKey(dateWithOutTime)) amount += result.get(dateWithOutTime);

            result.put(dateWithOutTime,amount);
        }

        return result;
    }

    private static class StatisticStorage{
        private Map<EventType, List<EventDataRow>> storage ; // КАРТА!!!!!!!

        public StatisticStorage( ) {
            storage =  new HashMap<>();
            for (EventType eventType: EventType.values()
                    ) {
                storage.put(eventType,new ArrayList<EventDataRow>());
            }
            //4. В конструкторе StatisticStorage инициализируй хранилище данными по-умолчанию:
            //например используя цикл, для каждого EventType добавь new ArrayList<EventDataRow>()
        }
        private void put(EventDataRow data){
            storage.get(data.getType()).add(data); // добавляет поле data типа EventDataRow согласно одному из трех EventDataRow
        }

        public List<EventDataRow> getEventsByType(EventType eventType) {
            return storage.get(eventType);
        }

        private List<EventDataRow> getAllRowsOfType(EventType eventType)
        {
            return storage.get(eventType);
        }

    }

    public void register(Cook cook) {// который зарегистрирует полученного повара.
        cooks.add(cook);
    }
}
