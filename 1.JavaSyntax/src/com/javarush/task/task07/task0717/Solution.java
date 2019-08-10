package com.javarush.task.task07.task0717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удваиваем слова
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        // Считать строки с консоли и объявить ArrayList list тут
        int a = 0;
        //String s;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (a < 10)
        {
            a++;
            list.add(reader.readLine());
            //if (s.isEmpty()) break;
            //int x = Integer.parseInt(s);
        } // while

        ArrayList<String> result = doubleValues(list);

        // Вывести на экран result
        a = 0;
        while (a < result.size())
        {
            System.out.println(list.get(a));
            a++;
            //if (s.isEmpty()) break;
            //int x = Integer.parseInt(s);
        } // while
    }

    public static ArrayList<String> doubleValues(ArrayList<String> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            list.add(i, list.get(i));
            i++;
        }
        return list;
    }
}
