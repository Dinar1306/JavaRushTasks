package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        long maxByte = 0;
        String fileName;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fileName = br.readLine(); // считываем имя файла с клавы

        //Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available() > 0) //пока есть еще непрочитанные байты
        {
            int data = inputStream.read(); // прочитать очередной байт в переменную data
            // сравнение
            if (data>maxByte) maxByte = data;
        }

        inputStream.close(); //закрываем поток
        System.out.println(maxByte); //выводим на экран.
    }
}
