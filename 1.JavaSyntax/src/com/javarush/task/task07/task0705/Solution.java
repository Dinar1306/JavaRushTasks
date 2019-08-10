package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] massiv_big = new int[20];
        int[] massiv_1 = new int[10];
        int[] massiv_2 = new int[10];
        int i;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (i = 0; i<20; i++){
            massiv_big[i] = Integer.parseInt(reader.readLine());
        }
        for (i = 0; i<10; i++){
            massiv_1[i] = massiv_big[i];
        }
        for (i = 10; i<20; i++){
            massiv_2[i-10] = massiv_big[i];
        }
        for (i = 0; i<10; i++){
            System.out.println(massiv_2[i]);
        }
    }
}
