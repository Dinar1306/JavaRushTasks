package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] massiv = new int[15];
        int i;
        int summ_chet = 0;
        int summ_nechet = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i<15; i++){
            massiv[i] = Integer.parseInt(reader.readLine());
            if (i%2 == 0) summ_chet = summ_chet + massiv[i];
            else summ_nechet = summ_nechet + massiv[i];
        }
        if (summ_chet > summ_nechet) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");
    }
}
