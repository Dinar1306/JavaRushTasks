package com.javarush.task.task31.task3105;


import java.io.*;

import java.nio.file.Files;
import java.util.HashMap;

import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри, а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.


Требования:
1. В методе main создай ZipInputStream для архивного файла (второй аргумент main). Нужно вычитать из него все содержимое.
2. В методе main создай ZipOutputStream для архивного файла (второй аргумент main).
3. В ZipOutputStream нужно записать содержимое файла, который приходит первым аргументом в main.
4. В ZipOutputStream нужно записать все остальное содержимое, которое было вычитано из ZipInputStream.
5. Потоки для работы с архивом должны быть закрыты.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        String zipFileName = args[1];
        File file = new File(fileName);
        Map<String, ByteArrayOutputStream> hashMap = new HashMap<>();

        try {       //считываем архив
            FileInputStream zipFile = new FileInputStream(zipFileName);
            ZipInputStream zipInputStream = new ZipInputStream(zipFile);
            ZipEntry entry;
            String name = "";

            //long size;
            while((entry=zipInputStream.getNextEntry())!=null){
                name = entry.getName(); // получим название файла
                //положили в память файл из архива
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024]; //размер буфера
                int count = 0;
                while ((count = zipInputStream.read(buffer)) != -1) //пока есть данные
                    byteArrayOutputStream.write(buffer, 0, count); //пишем буфер откуда и докуда

                hashMap.put(name, byteArrayOutputStream);
            }
            zipInputStream.close();
            zipFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            FileOutputStream zipOutFile = new FileOutputStream(zipFileName);
            ZipOutputStream zipOutputStream = new ZipOutputStream(zipOutFile);

            for (Map.Entry<String, ByteArrayOutputStream> pair : hashMap.entrySet()) {
                if (pair.getKey().substring(pair.getKey().lastIndexOf("/") + 1).equals(file.getName())) continue;
                zipOutputStream.putNextEntry(new ZipEntry(pair.getKey()));
                zipOutputStream.write(pair.getValue().toByteArray());
            }

            ZipEntry zipEntry = new ZipEntry("new/" + file.getName());
            zipOutputStream.putNextEntry(zipEntry);
            Files.copy(file.toPath(), zipOutputStream);

            zipOutputStream.close();
            zipOutFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
