package com.javarush.task.task10.task1015;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Массив списков строк
Создать массив, элементами которого будут списки строк.
Заполнить массив любыми данными и вывести их на экран.


Требования:
1. Метод createList должен объявлять и инициализировать массив с типом элементов ArrayList.
2. Метод createList должен возвращать созданный массив.
3. Метод createList должен добавлять в массив элементы (списки строк). Списки должны быть не пустые.
4. Программа должна выводить данные на экран.
5. Метод main должен вызывать метод createList.
6. Метод main должен вызывать метод printList.
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код

        //создадим 2 строки:
        String s1 = "Строка1";
        String s2 = "Строка2";

        //Теперь положим их в список:
        ArrayList<String> list1 = new ArrayList<>();
        list1.add(s1);
        list1.add(s2);

        //Теперь список положим в массив:
        ArrayList<String>[] ArrOfLists = new ArrayList[1];
        ArrOfLists[0] = list1;

        /*
        ArrayList<String>[] tablica = new ArrayList<String>;
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(tablica));
        arrayList.add("раз");
        arrayList.add("два");
        arrayList.add("три");*/

        return ArrOfLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}