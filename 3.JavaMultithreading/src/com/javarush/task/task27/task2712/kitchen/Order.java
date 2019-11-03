package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

public class Order {
    private final Tablet tablet; //список всех блюд
    protected List<Dish> dishes; //список выбранных блюд

    /**
     * пределяет есть ли какие либо блюда в заказе
     * @return
     */
    public boolean isEmpty() {
        return dishes == null || dishes.isEmpty();
    }

    //возвращает пустую строку, если нет блюд в заказе, иначе вывод должен быть
    // аналогичным примеру в порядке добавления блюд.
    @Override
    public String toString() {
        if(dishes==null){
            return "";
        } else {
            return "Your order: "+dishes.toString()+" "+tablet;
        }
    }

    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        this.dishes = ConsoleHelper.getAllDishesForOrder();
    }

    /**
     * Get total cooking time int.
     * Продолжительность приготовления всего заказа.
     *
     * @return the int
     */
    public int getTotalCookingTime(){
        int totalTime = 0;
        for (Dish dish : dishes) {
            totalTime += dish.getDuration();
        }

        return totalTime;
    }



}
