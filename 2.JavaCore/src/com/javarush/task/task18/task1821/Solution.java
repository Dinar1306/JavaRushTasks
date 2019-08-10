package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).

Пример:
','=44, 's'=115, 't'=116.

Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.

Пример вывода:
, 19
- 7
f 361


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception{
        FileInputStream fin = new FileInputStream(args[0]);        //("D:/OneDrive/JR/strings3.txt");
        //System.out.printf("File size: %d bytes \n", fin.available());
        byte[] simvols = new byte[fin.available()]; //массив эд-ов типа byte соответствующего размера файлу
        int s = -1;
        int i = 0;
        while((s=fin.read())!=-1){ // считываем побайтно
            simvols[i] = (byte)s;
            i++;
            //System.out.print((char)i);
            }
            fin.close();
        Map treeMap = new TreeMap<Integer, Byte>();
        int count = 1;
        int size = i;
        i = 0;
        int keycount = 0;
        for (i = 0; i < size; i++){
            treeMap.put(i, simvols[i]); // перегоняем в тримап для подсчета повторений
        }// for i
        Map<Byte, Integer> letters = new HashMap<>();
        for (i = 0; i < size; i++) {
            Object tempChar = treeMap.get(i);
         //   сколько раз такой-то символ
            if (!letters.containsKey(tempChar)) {
                letters.put((byte)tempChar, 1);
            } else {
                letters.put((byte) tempChar,  (letters.get(tempChar) + 1));
            }
        }
        //меняем местами ключ и значение, переводя byte в char
        Map<Character, Integer> chartreeMap = new HashMap<Character, Integer>();
        for (Map.Entry<Byte, Integer> entry : letters.entrySet()) {
            chartreeMap.put((char)(int)entry.getKey(), entry.getValue());
        }

        // получаем сортированный тримап по коду ASCII
        Map<Integer, Integer> finaltreeMap = new TreeMap<Integer, Integer>();
        for (Map.Entry<Character, Integer> entry : chartreeMap.entrySet()) {
            finaltreeMap.put((int)entry.getKey(), entry.getValue());

        }

        // выводим на печать переводя код ASCII в символ
        for (Map.Entry<Integer, Integer> entry : finaltreeMap.entrySet()) {
            System.out.println((char)(int)entry.getKey() + " " + entry.getValue());
       }

    } // main




}
