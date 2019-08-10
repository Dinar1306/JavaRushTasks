package com.javarush.task.task18.task1810;

/* 
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Требования:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        while(true) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[fileInputStream.available()];
            int size = fileInputStream.read(buffer);
            fileInputStream.close();
            if (size < 1000) {
                throw new DownloadException();
            }

        }
    }

    public static class DownloadException extends Exception {

    }
}


/*  короткое решение:
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream;
        while((inputStream=new FileInputStream(reader.readLine())).available()>999){
        }
        inputStream.close();
        throw new DownloadException();
*/