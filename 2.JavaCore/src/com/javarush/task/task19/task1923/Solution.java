package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со словами, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.


Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
5. Поток записи в файл (FileWriter) должен быть закрыт.
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
        for (int i = 0; i < values.length; i++) {
            if(values[i].chars().anyMatch(Character::isDigit )) {
                //собираем без лишних пробелов в начале и в конце  ¯\_(ツ)_/¯
                if (i==0) {slovo += values[i];} else if (i==values.length){} else slovo += " " + values[i];
            }
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName2));

        bw.write(slovo);
        // all closed!
        br.close();
        bw.close();
    }
}
