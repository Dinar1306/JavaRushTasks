package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        ArrayList<String> strings = new ArrayList<String>();;
        int min = 50;
        //strings 
        //ArrayList<Integer> list = new ArrayList();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<5; i++) {
            strings.add(i, reader.readLine());
            if (strings.get(i).length() < min) min = strings.get(i).length();
        } // for i ввели пять строк
        for (int i = 0; i<5; i++) {
            //strings.add(i, reader.readLine());
            if (strings.get(i).length() == min) System.out.println(strings.get(i));;
        } // for i ввели пять строк
    }
}
