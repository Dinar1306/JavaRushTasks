package com.javarush.task.task07.task0720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Перестановочка подоспела
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
                //напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        int n;
        n = (int)Integer.parseInt(reader.readLine());
        int m;
        m = (int)Integer.parseInt(reader.readLine());
        //System.out.println("n="+n+", m="+m);
        for (int i = 0; i < n; i++){
            String s = reader.readLine();
            list.add(s);
            //list.add(i, reader.readLine());
        } // ввели n СТРОК
        int z = 0; //  промеж. счетчик для учета количества перестановок, чтоб всегда считывать первый эл.
        for (int i = 0; i < m; i++){
            list.add(list.get(i-z));
            list.remove(0);
            z++;
        } // перенесли m СТРОК в конец
        for (int i = 0; i < n; i++){
            System.out.println(list.get(i));
        } // вывели
    }
}
