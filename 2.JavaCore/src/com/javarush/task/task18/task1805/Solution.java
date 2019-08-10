package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт

Сортировка байт
Ввести с консоли имя файла.
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран.
Закрыть поток ввода-вывода.

Пример байт входного файла:
44 83 44

Пример вывода:
44 83


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все уникальные байты из файла в порядке возрастания.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> massiv = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int data = fileInputStream.read();
            if (hashMap.containsKey(data)){
                int count = 1 + hashMap.get(data);
                hashMap.put(data, count);
            } else {
                hashMap.put(data, 1);
            }
        }
/*        int res = 255;
        for (Integer i : hashMap.values()){
            if (i < res) {
                res = i;
            }
        }*/
        for (Map.Entry<Integer, Integer> i : hashMap.entrySet()){
            massiv.add(i.getKey());
        }
        Collections.sort(massiv);
        //System.out.println(massiv);

        for (int b: massiv){//в цикле выводим
            System.out.print(b + " ");// добавляем пробел при выводе
        }

        fileInputStream.close();
    }
}
