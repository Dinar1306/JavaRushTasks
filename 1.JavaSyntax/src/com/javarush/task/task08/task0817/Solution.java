package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
/* 
Нам повторы не нужны
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код

        ArrayList<String> list = new ArrayList<>();


        for (Map.Entry<String, String> dupl : map.entrySet()) {
            int n = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (dupl.getValue().equals(entry.getValue())) {
                    n++;
                    if (n > 1) {
                        if (n == 2) {
                            list.add(dupl.getValue());
                        }
                        list.add(entry.getValue());
                    }
                }
            }
        }

        for (String s : list) {
            removeItemFromMapByValue(map, s);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
