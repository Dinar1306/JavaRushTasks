package com.javarush.task.task19.task1925;

/* 
Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6.
В конце файла2 запятой не должно быть.
Закрыть потоки.

Пример выходных данных в файл2:
длинное,короткое,аббревиатура


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        String slovo = ""; //временная пустая строка для составления слова из символов

        String fileName1 = args[0];  //todo в первом аргументе имя первого файла
        String fileName2 = args[1];  //todo в первом аргументе имя второго файла

        BufferedReader br = new BufferedReader(new FileReader(fileName1));
        while (br.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = br.read(); //читаем один символ (char будет расширен до int)

            slovo += (char) data;
        }   //while
        slovo = slovo.replaceAll(System.getProperty("line.separator"), " "); //убираем переводы строк
        //array = buffer.split(" ");
        Pattern pattern = Pattern.compile(" ");
        String[] values = pattern.split(slovo);
        slovo = "";
        //StringBuilder builder = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            if(values[i].length() > 6) {
                //собираем без лишних пробелов в начале и в конце  ¯\_(ツ)_/¯
                if (i==values.length-1) {slovo += values[i]; } else if (i==values.length){} else slovo += values[i]+",";
            }
        }
        slovo = slovo.subSequence(0,slovo.length()-1).toString(); //записываем без последней запятой
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2));
        bw.write(slovo);
        // all closed!
        br.close();
        bw.close();
    }
}
