package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        long minByte = Long.MAX_VALUE;
        String fileName;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fileName = br.readLine(); // считываем имя файла с клавы

        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            // сравнение
            if (data<minByte) minByte = data;

        }

        inputStream.close(); //закрываем поток
        System.out.println(minByte); //выводим на экран.
    }
}
