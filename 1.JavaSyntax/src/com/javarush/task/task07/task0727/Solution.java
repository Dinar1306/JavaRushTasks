package com.javarush.task.task07.task0727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Меняем функциональность
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        ArrayList<String> listNewSize = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            //listNewSize.add(s.toUpperCase());
            if ((s.length())%2 == 0) {
                s = list.get(i) + " " + list.get(i);
                listNewSize.add(i, s);
            }
            else {
                s = list.get(i) + " " +  list.get(i) + " " + list.get(i);
                listNewSize.add(i, s);
            }
        }

        for (int i = 0; i < listNewSize.size(); i++) {
            System.out.println(listNewSize.get(i));
        }
    }
}
