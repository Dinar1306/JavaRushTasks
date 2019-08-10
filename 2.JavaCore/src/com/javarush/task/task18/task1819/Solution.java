package com.javarush.task.task18.task1819;

/* 
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.


Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Не используй в программе статические переменные.
3. Для первого файла создай поток для чтения и считай его содержимое.
4. Затем, для первого файла создай поток для записи(поток для записи должен быть один). Для второго - для чтения.
5. Содержимое первого и второго файла нужно объединить в первом файле.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();   // имя первого фала
        String file2 = reader.readLine();   // имя второго файла
        FileInputStream fis = new FileInputStream(file1); // поток для чтения первого файла
        byte[] buffer1 = new byte[fis.available()];         // создаем массив байт соответствующего размера
        if (fis.available() > 0) {
            fis.read(buffer1);
        }
        ByteArrayInputStream bais1 = new ByteArrayInputStream(buffer1); // считываем весь массив байтов передав buffer в конструктор
        fis.close();    // закрываем поток чтения первого файла
        fis = new FileInputStream(file2);  // поток для чтения второго файла
        byte[] buffer2 = new byte[fis.available()];  // создаем массив байт соответствующего размера
        if (fis.available() > 0) {
            fis.read(buffer2);      // Считываем разом байты в массив
        }
        //ByteArrayInputStream bais2 = new ByteArrayInputStream(buffer2); // считываем весь массив байтов передав buffer в конструктор
        fis.close();   // закрываем поток чтения второго файла

        byte[] bigbuff = new byte[buffer1.length + buffer2.length]; // создаем большой массив для двух
        System.arraycopy(buffer2, 0, bigbuff, 0, buffer2.length); // пишем в начало большого от начала второго весь второй
        System.arraycopy(buffer1, 0, bigbuff, buffer2.length, buffer1.length); // пишем в продолжение большого от начала первого весь первый

        FileOutputStream fos = new FileOutputStream(file1); //создаем поток записи второго файла
        fos.write(bigbuff);  // пишем большой массив байт в первый файл

        //byte[] buffer1 = new byte[fis.available()];
//        BufferedInputStream bos = new BufferedInputStream(fis);
//        bos.readAllBytes();
//        for (int i = size-1; i >= 0; i--){
//              write(buffer[i]);
//        }
//        FileOutputStream fos = new FileOutputStream(file1);
//        fos.write(buffer);
//
//        fis = new FileInputStream(file2);
//
//        byte[] buffer2 = new byte[fis.available()];
//        int size = fis.read(buffer2);
//        for (int i = size-1; i >= 0; i--){
//                fos.write(buffer2[i]);
//         }
//        fos.write(buffer);

//        fis.close(); //закрываем оба потока. Они больше не нужны. (№2)
        fos.close();
        reader.close();


        //byte[] buffer = new byte[fis.available()];

    }
}
