package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* 
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
Пустые строки даны в примере для наглядности.
В оригинальном и редактируемом файлах пустых строк нет!

Пример 1:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
строка4                            REMOVED строка4
строка5         строка5            SAME строка5
                строка0            ADDED строка0
строка1         строка1            SAME строка1
строка2                            REMOVED строка2
строка3         строка3            SAME строка3
                строка4            ADDED строка4
строка5         строка5            SAME строка5
строка0                            REMOVED строка0

Пример 2:
оригинальный    редактированный    общий
file1:          file2:             результат:(lines)

строка1         строка1            SAME строка1
                строка0            ADDED строка0

Пустые строки в примере означают, что этой строки нет в определенном файле.


Требования:
1. Класс Solution должен содержать класс LineItem.
2. Класс Solution должен содержать enum Type.
3. Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
4. В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
5. В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String slovo = ""; //временная пустая строка для составления слова из символов
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = /*reader.readLine();   //имя файла */ "D:/OneDrive7/OneDrive/JR/file1.txt"; //  //todo// получаем имя файла с консоли
        String fileName2 = /*reader.readLine();   //имя файла */ "D:/OneDrive7/OneDrive/JR/file2.txt"; // //todo// получаем имя файла с консоли
        reader.close();
        // читаем первый файл
        BufferedReader br1 = new BufferedReader(new FileReader(fileName1));
        while (br1.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = br1.read(); //читаем один символ (char будет расширен до int)
            slovo += (char) data;
        }   //while
        Pattern pattern = Pattern.compile("\r\n"); // разбиваем на строки
        String[] values1 = pattern.split(slovo); //таблица из строк первого файла

        slovo = ""; //обнуляем временную строку

        // читаем второй файл
        BufferedReader br2 = new BufferedReader(new FileReader(fileName2));
        while (br2.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = br2.read();                //читаем один символ (char будет расширен до int)
            slovo += (char) data;
        }   //while
        pattern = Pattern.compile("\r\n");       // разбиваем на строки
        String[] values2 = pattern.split(slovo); //таблица из строк второго файла

        br1.close();
        br2.close();

        // у кого строк больше?
        LineItem lineItem; //элементы листа line
        int max, i;
        int max1 = 0;
        int max2 = 0;
        if (values1.length>values2.length) max1 = values1.length;
        else max2 = values2.length;
        if (max1>max2) { // счетчик по первому файлу
            //начинаем сравнение
            i = 0;              //обнуление бугунка по строкам
            while (i <= max1 - 1) {
                if (values1[i].equals(values2[i])) {
                    lines.add(new LineItem(Type.SAME, values1[i]));
                } else if (values1[i+1].equals(values2[i])) { // след.строка первого со строкой второго
                    lines.add(new LineItem(Type.REMOVED, values1[i]));
                } else if (values1[i].equals(values2[i+1])) { // след.строка первого со строкой второго
                    lines.add(new LineItem(Type.ADDED, values1[i]));
                }
                i++;
            } // while

        } else {        // иначе счетчик по второму файлу
            //начинаем сравнение
            i = 0;              //обнуление бугунка по строкам
            while (i <= max2 - 1) {
                if (values1[i].equals(values2[i])) {
                    lines.add(new LineItem(Type.SAME, values1[i]));
                } else if (values1[i+1].equals(values2[i])) { // след.строка первого со строкой второго
                    lines.add(new LineItem(Type.REMOVED, values1[i]));
                } else if (values1[i].equals(values2[i+1])) { // след.строка первого со строкой второго
                    lines.add(new LineItem(Type.ADDED, values1[i]));
                }
                i++;
            } // while

        }





    } //main



    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
