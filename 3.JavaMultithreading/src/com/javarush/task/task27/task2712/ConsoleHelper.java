package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.kitchen.Order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class ConsoleHelper {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){//для вывода message в консоль
        System.out.println(message);
    }

    public static String readString() throws IOException { // для чтения строки с консоли
        return br.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException { //просит пользователя выбрать блюдо и добавляет его в список.
        List<Dish> dishes = new ArrayList<>(); // создадим список для выбранных пользователем блюд
        ConsoleHelper.writeMessage("Выберите необходимое блюдо... Если закончили - введите 'exit'");
        ConsoleHelper.writeMessage(Dish.allDishesToString()); //выведем список блюд

        String selectDish;
        while (!(selectDish = readString()).equalsIgnoreCase("exit")) { // пока пользователь не набрал exit считывае блюда
            try {
                dishes.add(Dish.valueOf(selectDish)); //находим в ENUM введенное блюдо и добавляем его в список выбора
            } catch (IllegalArgumentException e) {
                ConsoleHelper.writeMessage("Блюдо отсутствует!"); // если блюда нет в ENUM, сообщим пользователю
            }
        }
        return dishes;
    }
}
