package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: "May is 5 month".
Используйте коллекции.


Требования:
1. Программа должна считывать одно значение с клавиатуры.
2. Программа должна выводить текст на экран.
3. Программа должна использовать коллекции.
4. Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("January", 1);
        hm.put("February", 2);
        hm.put("March", 3);
        hm.put("April", 4);
        hm.put("May", 5);
        hm.put("June", 6);
        hm.put("Jule", 7);
        hm.put("August", 8);
        hm.put("September", 9);
        hm.put("October", 10);
        hm.put("November", 11);
        hm.put("December", 12);
        System.out.println(month+" is "+hm.get(month)+" month");
    }
}
