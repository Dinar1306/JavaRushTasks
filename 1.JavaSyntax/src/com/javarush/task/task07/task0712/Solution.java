package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int max_num = 0;
        int min_num = 0;
        int max = 0;
        int min = 127;
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(rd.readLine());
        }
        for (int i = 0; i < 10; i++) {
            if (list.get(i).length() < min) {
                min = list.get(i).length();
                min_num = i;
            } // if min
        }
        for (int i = 0; i < 10; i++) {
            if (list.get(i).length() > max) {
                max = list.get(i).length();
                max_num = i;
            } // if max
        }
        //System.out.println("max_num = "+max_num);
       // System.out.println("min_num = "+min_num);
        if (min_num < max_num) System.out.println(list.get(min_num));
        else System.out.println(list.get(max_num));
    }
}
