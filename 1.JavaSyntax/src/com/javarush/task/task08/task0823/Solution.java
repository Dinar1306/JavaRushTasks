package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;

/* 
Омовение Рамы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
мама мыла раму.

Пример вывода:
Мама Мыла Раму.


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать строку с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна заменять в тексте первые буквы всех слов на заглавные.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        char[] bukvy;
        bukvy = s.toCharArray();
        //bukvy[0] = Character.toUpperCase(bukvy[0]);
        for (int i = 0; i < bukvy.length-1; i++) {
           /* тоже не работает
            if (Character.isWhitespace(bukvy[i])) {
                     Character.toUpperCase(bukvy[i + 1]);
                     System.out.println(bukvy[i + 1]);
            }
            */
            if (bukvy[i] == ' ') {
                bukvy[i + 1] = Character.toUpperCase(bukvy[i + 1]);
            }
        }
        s = new String(bukvy); // bukvy.toString() не работате (дает ссылку)

        System.out.println(s);
    }
}
