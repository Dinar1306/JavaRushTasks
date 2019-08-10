package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла

Считать с консоли имя файла.
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int).
Закрыть потоки.

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity
где id - int.
productName - название товара, может содержать пробелы, String.
price - цена, double.
quantity - количество, int.

Информация по каждому товару хранится в отдельной строке.


Требования:
1. Программа должна считать имя файла с консоли.
2. Создай для файла поток для чтения.
3. Программа должна найти в файле и вывести информацию о id, который передается первым параметром.
4. Поток для чтения из файла должен быть закрыт.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName;
        int chisloStrok = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fileName = br.readLine(); // "D:/OneDrive/JR/strings4.txt"; считываем имя файла с клавы //todo
        FileInputStream inputStream = new FileInputStream(fileName); // задаем поток для чтения
        ArrayList<String> str = new ArrayList<>(); // готовим массив строк для считывания в него текстового файла
//        byte[] buffer = new byte[inputStream.available()]; //читаем второй файл
//        if (inputStream.available() > 0) {  //читаем весь файл одним куском
//            int count = inputStream.read(buffer);     // и получаем размер файла
//        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)); // подготовили буфферед ридер
        String line = reader.readLine();
        while (line != null) { // читаем файл построчно
            str.add(line);
            line = reader.readLine();
            chisloStrok++;
        }
        inputStream.close();
        //int look = Integer.parseInt(args[0]);   // перевели строковый параметр на входе в тип int для его поиска в файле
        String[] podstroki;
        for (int i = 0; i <= chisloStrok; i++) {
            podstroki = str.get(i).split(" ");
            if (podstroki[0].equals(args[0])) {
                System.out.println(str.get(i));
                i = chisloStrok;
            }
            } // for
        }
    }

