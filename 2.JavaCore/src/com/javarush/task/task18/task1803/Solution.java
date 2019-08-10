package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;


/* 
Самые частые байты
Ввести с консоли имя файла.
Найти байт или байты с максимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с максимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
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
        int res = 0;
        for (Integer i : hashMap.values()){ //находим макс. кол-во повторений
            if (i > res) {
                res = i;
            }
        }
        for (Map.Entry<Integer, Integer> i : hashMap.entrySet()){
            if (i.getValue() == res) {
                System.out.print(i.getKey()+" ");
            }
        }
        fileInputStream.close();
    }
}
