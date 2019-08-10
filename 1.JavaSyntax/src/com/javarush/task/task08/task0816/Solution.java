package com.javarush.task.task08.task0816;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Stella", new Date("February 1 1980"));
        map.put("Suzana", new Date("March 1 1980"));
        map.put("Denchik", new Date("April 1 1980"));
        map.put("Russy", new Date("May 5 1980"));
        map.put("Pups", new Date("June 1 1980"));
        map.put("Euzana", new Date("July 1 1980"));
        map.put("Tenchik", new Date("August 1 1980"));
        map.put("Yussy", new Date("September 1 1980"));
        map.put("Uups", new Date("October 1 1980"));
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator <Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        int month;
        Map.Entry<String, Date> pair;
        while (iterator.hasNext()){
            pair = iterator.next();
            month = pair.getValue().getMonth();
            if (month > 4 && month < 8){
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {

    }
}
