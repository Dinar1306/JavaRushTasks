package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] massiv_strok = new String[10];
        int[] massiv_dlin = new int[10];
        int i;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i<10; i++){
            massiv_strok[i] = reader.readLine();
            massiv_dlin[i] = massiv_strok[i].length();

        }
        for (i = 0; i<10; i++){
            System.out.println(massiv_dlin[i]);
        }
    }
}
