package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] massiv = new int[20];
        for (int i=0; i<20; i++){
            massiv[i] = Integer.parseInt(reader.readLine());
        }
        maximum = massiv[0];
        for (int i=1; i<20; i++){
            if (massiv[i] > maximum) maximum = massiv[i];
        }
        minimum = massiv[0];
        for (int i=1; i<20; i++){
            if (massiv[i] < minimum) minimum = massiv[i];
        }

        System.out.println(maximum);
        System.out.println(minimum);
    }
}
