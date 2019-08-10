package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> spisok = new ArrayList<Integer>();
        ArrayList<Integer> odd = new ArrayList<Integer>();
        ArrayList<Integer> even = new ArrayList<Integer>();
        ArrayList<Integer> other = new ArrayList<Integer>();
        String s;

        while (a < 20)
        {
            a++;
            s = reader.readLine();
            if (s.isEmpty()) break;
            int x = Integer.parseInt(s);
            spisok.add(x);
        } // while
            for (int i = 0; i < spisok.size(); i++) {
                if ((spisok.get(i) % 2 == 0) & (spisok.get(i) % 3 == 0)) {
                    even.add(spisok.get(i));          //добавление в чет
                    odd.add(spisok.get(i));      //вставка в нечет
                } // if %2 & %3


                else if (spisok.get(i) % 3 == 0)
                    odd.add(spisok.get(i));      //вставка в нечет


               else if (spisok.get(i) % 2 == 0)
                      even.add(spisok.get(i));

                else other.add(spisok.get(i));
                } // for i

        printList(odd);
        printList(even);
        printList(other);

        /*
        for (int i = 0; i<20; i++){
            spisok.add(Integer.parseInt(reader.readLine()));
            if (Integer.parseInt(spisok.get(i))%2 == 0) {
                a = spisok.get(i)
            }
        }*/


    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
