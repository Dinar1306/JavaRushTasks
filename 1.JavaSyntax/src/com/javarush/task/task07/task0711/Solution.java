package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int d = 0;
        String s;
        ArrayList<String> strings = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<5; i++) {
            strings.add(i, reader.readLine());
        }
        for (int i = 13; i>0; i--) {
            s = strings.get(4);
            strings.remove(4);
            strings.add(0, s);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(strings.get(i));
        }
    }
}
