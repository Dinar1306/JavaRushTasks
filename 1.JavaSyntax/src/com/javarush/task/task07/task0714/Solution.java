package com.javarush.task.task07.task0714;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Слова в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 0;
        //String s;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> spisok = new ArrayList<String>();
        while (a < 5)
        {
            a++;
            spisok.add(reader.readLine());
            //if (s.isEmpty()) break;
            //int x = Integer.parseInt(s);
        } // while
        spisok.remove(2);
        for (int i = 0; i < spisok.size(); i++)
            System.out.println(spisok.get(spisok.size()-1-i));
    }
}


