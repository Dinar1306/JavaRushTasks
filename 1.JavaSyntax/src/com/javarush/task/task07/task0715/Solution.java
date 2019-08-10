package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> spisok = new ArrayList<String>();
        spisok.add("мама");
        spisok.add("мыла");
        spisok.add("раму");
        int size = spisok.size();
        for (int i = 0; i < size; i++)
        {
            spisok.add((i*2)+1, "именно");
            //size = spisok.size();
        }
        for (int i = 0; i < spisok.size(); i++)
        {
            System.out.println(spisok.get(i));
        }
    }
}
