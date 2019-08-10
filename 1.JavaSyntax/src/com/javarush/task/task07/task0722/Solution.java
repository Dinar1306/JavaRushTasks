package com.javarush.task.task07.task0722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Это конец
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        String s;
        boolean stop = false;
        int value = 0;
        //напишите тут ваш код
        while (stop != true){
            s = reader.readLine();
            if (!s.equals("end")) {
                list.add(s);
                value++; //считаем сколько строк, но можно не считать - list.size();
                //System.out.println(value);
            } // if s
            else stop = true;
        } // вводим СТРОКИ пока не введем end
        // далее в цикле for выводим список
        for (String stroka : list) {
            System.out.println(stroka);
        }
    }
}