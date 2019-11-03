package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;


    Dish(int duration) {
        this.duration = duration;
    }

    //Чтобы пользователь мог выбрать себе блюда, нужно их все ему отобразить.
    // Для этого в Dish создай метод
    public static String allDishesToString(){ // который сформирует строку из всех блюд.
        return String.format(Fish.toString()+"\n"+Steak.toString()+"\n"+Soup.toString()+"\n"+Juice.toString()+"\n"+Water.toString());
    }

    public int getDuration() {
        return duration;
    }
}
