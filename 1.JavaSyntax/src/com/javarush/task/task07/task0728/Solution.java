package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
В убывающем порядке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        int bufer;
        for (int i=0; i<20; i++){
            for (int j=i+1; j<20; j++){
                if (array[i] < array[j]) {
                    bufer = array[i];
                    array[i] = array[j];
                    array[j] = bufer;
                }
            } // for j
        } // for i
    }
}
