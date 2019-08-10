package com.javarush.task.task07.task0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
/* 
Массив из строчек в обратном порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] massiv = new String[10];
        int i;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i<8; i++){
            massiv[i] = reader.readLine();
        }
        for (i = 0; i<10; i++){
            System.out.println(massiv[9-i]);
        }
    }
}