package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        int i;
        String s1, s2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        for (i=0; i<10; i++) list.add(reader.readLine());
        for (i=0; i<(list.size()-1); i++){
            s1 = list.get(i);
            s2 = list.get(i+1);
            if (s1.length()>s2.length()) {
                System.out.println(i+1);
                i=list.size()-1; // break;
            }
            
        }  //for i;
        //System.out.print(list);
    }
}

