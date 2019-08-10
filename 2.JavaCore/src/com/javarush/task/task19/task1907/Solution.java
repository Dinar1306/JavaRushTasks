package com.javarush.task.task19.task1907;

/* 
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

        int count = 0;
        String slovo = ""; //временная пустая строка для составления слова из символов
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // объект буферного потока ввода
        String file =  br.readLine();   //имя файла "D:/OneDrive/JR/res1.txt"; //  //todo
        FileReader reader = new FileReader(file); // готовим читатель файла посимвольно
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            // составляем из символов одно слово, ориентируясь на пробелы, если слово=world, то count++ - так не работает
            // необходимо составлять слово " world " и так не работает
            slovo += (char)data;
        }   //while
        Pattern pattern = Pattern.compile("[\\p{Punct}\\s]+");
        String[] values = pattern.split(slovo);

        for (int i = 0; i < values.length; i++) {
            if(values[i].equals("world")) {
                count++;
            }
        }
        System.out.println(count);
        //закрываем потоки после использования
        reader.close();
        br.close();
    }
}
