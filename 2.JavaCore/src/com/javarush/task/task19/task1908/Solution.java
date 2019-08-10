package com.javarush.task.task19.task1908;

/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.

Пример тела файла:
12 text var2 14 8ю 1

Результат:
12 14 1


Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором принимающим FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String slovo = ""; //временная пустая строка для составления слова из символов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();   //имя файла "D:/OneDrive/JR/file1.txt"; //  //todo// получаем имя файла с консоли
        String fileName2 = reader.readLine();   //имя файла "D:/OneDrive/JR/file2.txt"; // //todo// получаем имя файла с консоли
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        //br.readLine();
        while (br.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = br.read(); //читаем один символ (char будет расширен до int)
            // составляем из символов одно слово, ориентируясь на пробелы, если слово=world, то count++ - так не работает
            // необходимо составлять слово " world " и так не работает
            slovo += (char) data;
        }   //while
        Pattern pattern = Pattern.compile(" ");
        String[] values = pattern.split(slovo);
        slovo = "";
        for (int i = 0; i < values.length; i++) {
            if(values[i].chars().allMatch( Character::isDigit )) {
                slovo += values[i] + " ";
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2));
        bw.write(slovo);
        System.out.println(values);
        br.close();
        bw.close();
    }
}
