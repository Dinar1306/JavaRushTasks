package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] massiv = new int[10];
        int i;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i<10; i++){
            massiv[i] = Integer.parseInt(reader.readLine());
        }
        for (i = 0; i<10; i++){
            System.out.println(massiv[9-i]);
        }
    }
}

