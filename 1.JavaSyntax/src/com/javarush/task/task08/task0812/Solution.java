package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> chisla = new ArrayList<Integer>();
        
        for (int i = 0; i < 10; i++){
            String num = reader.readLine();
            int number = Integer.parseInt(num);
            chisla.add(i, number);
        } //for i ввод;
        int count = 1; // счётчик
        int max = 1; 
        for (int i = 1; i < 10; i++) { 
            if (chisla.get(i) == chisla.get(i-1)) count++; 
            else count = 1; if (max<count) max = count; 
        } 
        System.out.println(max);
    }
}