package com.javarush.task.task18.task1808;

/* 
Разделение файла
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream1 = new FileOutputStream(file2);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file3);
        byte[] buffer = new byte[fileInputStream.available()];
        int size = fileInputStream.read(buffer);
        if (size % 2 == 0) {
            fileOutputStream1.write(buffer, 0, size/2);
            fileOutputStream2.write(buffer, size/2, size/2);
        }   else {
            fileOutputStream1.write(buffer, 0, size/2+1);
            fileOutputStream2.write(buffer, size/2+1, size/2);
        }
        fileInputStream.close(); //закрываем оба потока. Они больше не нужны. (№2)
        fileOutputStream1.close();
        fileOutputStream2.close();
        reader.close();
    }
}
