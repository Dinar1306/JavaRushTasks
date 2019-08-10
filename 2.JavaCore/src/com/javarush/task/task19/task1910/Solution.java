package com.javarush.task.task19.task1910;

/* 
Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Считать содержимое первого файла, удалить все знаки пунктуации, включая символы новой строки.

Результат вывести во второй файл.

Закрыть потоки.
Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл содержимое первого файла, где удалены все знаки пунктуации, включая символы новой строки (Для записи в файл используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.

*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();   //имя файла "D:/OneDrive/JR/file1.txt"; //  //todo// получаем имя файла с консоли
        String fileName2 = reader.readLine();   //имя файла "D:/OneDrive/JR/file2.txt"; // //todo// получаем имя файла с консоли
        reader.close();
        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2));
        Pattern p = Pattern.compile("\\p{Punct}"); //выборка по знакам пунктуации
        //Matcher m = p.matcher("aaaaab");
        //boolean b = m.matches();
        //равно
        // boolean b = Pattern.matches("a*b", "aaaaab");

        while (br.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = br.read(); //читаем один символ (char будет расширен до int)
            Matcher m = p.matcher(Character.toString((char) data)); // подаем на сравнение считаннй символ (int->char->String)
            if (!(m.matches())&!((char) data == '\n')) {
                bw.write(data);
            }

        }   //while
        br.close();
        bw.close();
    }
}
//============================================

//    public static void main(String[] args) throws Exception
//    {
//        //запоминаем настоящий PrintStream в специальную переменную
//        PrintStream consoleStream = System.out;
//
//        //Создаем динамический массив
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        //создаем адаптер к классу PrintStream
//        PrintStream stream = new PrintStream(outputStream);
//        //Устанавливаем его как текущий System.out
//        System.setOut(stream);
//
//        //Вызываем функцию, которая ничего не знает о наших манипуляциях
//        printSomething();
//
//        //Преобразовываем записанные в наш ByteArray данные в строку
//        String result = outputStream.toString();
//
//        //Возвращаем все как было
//        System.setOut(consoleStream);
//
//        //разворачиваем строку
//        StringBuilder stringBuilder = new StringBuilder(result);
//        stringBuilder.reverse();
//        String reverseString = stringBuilder.toString();
//
//        //выводим ее в консоль
//        System.out.println(reverseString);
//    }
//
//    public static void printSomething()
//    {
//        System.out.println("Hi");
//        System.out.println("My name is Amigo");
//        System.out.println("Bye-bye!");
//    }}