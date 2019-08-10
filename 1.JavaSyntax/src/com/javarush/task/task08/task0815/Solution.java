package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.HashSet;

/* 
Перепись населения
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

            map.put("Иванов","Иван");
            map.put("Иванов1","Иван1");
            map.put("Иванов2","Иван2");
            map.put("Иванов0","Иван");
            map.put("Иванов11","Иван3");
            map.put("Иванов3","Иван4");
            map.put("Иванов4","Иван5");
            map.put("Иванов5","Иван6");
            map.put("Иванов6","Иван7");
            map.put("Иванов7","Иван8");

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        //напишите тут ваш код
        int count = 0;
        for (String value : map.values()) {
            if (name.equals(value)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        //напишите тут ваш код
        int count = 0;
        for (String key : map.keySet()) {
            if (lastName.equals(key)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
