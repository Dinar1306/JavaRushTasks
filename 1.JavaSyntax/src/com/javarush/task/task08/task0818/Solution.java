package com.javarush.task.task08.task0818;


import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        map.put("Иванов",500);
        map.put("Иванов1",600);
        map.put("Иванов2",700);
        map.put("Иванов0",750);
        map.put("Иванов11",450);
        map.put("Иванов3",550);
        map.put("Иванов4",555);
        map.put("Иванов5",620);
        map.put("Иванов6",650);
        map.put("Иванов7",800);

        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator <Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        Integer zarplata = 500;
        Integer chekZarplata;
        Map.Entry<String, Integer> pair;
        while (iterator.hasNext()){
            pair = iterator.next();
            chekZarplata = pair.getValue();
            if (chekZarplata < zarplata){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {

    }
}