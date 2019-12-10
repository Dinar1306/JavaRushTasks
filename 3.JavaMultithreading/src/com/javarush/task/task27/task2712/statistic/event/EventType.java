package com.javarush.task.task27.task2712.statistic.event;

public enum EventType {

    //У нас выделяются несколько событий:
    //*повар приготовил заказ
    //*выбрали набор видео-роликов для заказа
    //*нет ни одного видео-ролика, который можно показать во время приготовления заказа

    COOKED_ORDER,
    SELECTED_VIDEOS,
    NO_AVAILABLE_VIDEO
}
