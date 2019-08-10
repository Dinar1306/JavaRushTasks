package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* 
Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.


Требования:
1. Программа НЕ должна считывать данные с клавиатуры.
2. Программа НЕ должна выводить данные на экран.
3. Программа должна записывать данные в файл.
4. Содержимое второго файла должно соответствовать содержимому первого файла за исключением кодировки(UTF-8).
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileNameIn = args[0];
        String fileNameOut = args[1];
        /*fileNameIn = "file_Windows-1251";
        fileNameOut = "file_UTF-8";*/

        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        // Создаем поток-чтения-байт-из-файла
        FileInputStream inputStream = new FileInputStream(fileNameIn);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(fileNameOut);

        //читаем весь файл одним куском
        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);
        String s = new String(buffer, windows1251);
        buffer = s.getBytes(utf8);
        outputStream.write(buffer);

        inputStream.close(); //закрываем оба потока. Они больше не нужны.
        outputStream.close();
    }
}
