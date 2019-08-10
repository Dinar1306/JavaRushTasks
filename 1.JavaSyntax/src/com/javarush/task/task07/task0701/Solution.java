package com.javarush.task.task07.task0701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Массивный максимум
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] array = initializeArray();
        int max = max(array);
        System.out.println(max);
    }

    public static int[] initializeArray() throws IOException {
            // создай и заполни массив
        int[] massiv = new int[20];
        int i;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i<20; i++){
            massiv[i] = Integer.parseInt(reader.readLine());
        }
        return massiv;
    }

    public static int max(int[] array) {
        // найди максимальное значение
        int i;
        int maximum = array[0];
        for (i = 1; i<20; i++){
            if (array[i] > maximum) maximum = array[i];
        }
        return maximum;
    }
}
