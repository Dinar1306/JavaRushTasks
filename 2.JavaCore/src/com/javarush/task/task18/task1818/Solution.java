package com.javarush.task.task18.task1818;

/* 
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1;
        String fileName2;
        String fileName3;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fileName1 = br.readLine(); // считываем имя файла с клавы
        fileName2 = br.readLine(); // считываем имя файла с клавы
        fileName3 = br.readLine(); // считываем имя файла с клавы
        //FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileInputStream inputStream3 = new FileInputStream(fileName3);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(fileName1);
        byte[] buffer2 = new byte[inputStream2.available()]; //читаем второй файл
        if (inputStream2.available() > 0) {  //читаем весь файл одним куском
            int count = inputStream2.read(buffer2);
            outputStream.write(buffer2, 0, count); // пишем в первый файл
        }

        byte[] buffer3 = new byte[inputStream3.available()]; //читаем третий файл
        if (inputStream3.available() > 0) {  //читаем весь файл одним куском
            int count = inputStream3.read(buffer3);
            outputStream.write(buffer3, 0, count);  // пишем в первый файл
        }

        inputStream2.close(); //закрываем оба потока. Они больше не нужны. (№2)
        inputStream3.close();
        outputStream.close();
    }
}
