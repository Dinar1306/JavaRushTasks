package com.javarush.task.task31.task3110;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {
    private Path zipFile; // полный путь к архиву, с которым будем работать.

    //конструктор
    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception { //Path source - это путь к чему-то, что мы будем архивировать.
        //1.Создай новый поток архива ZipOutputStream используя переменную класса zipFile, с помощью метода newOutputStream класса Files.
        //ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile));

        //2. Создай новый элемент архива ZipEntry.
        //В конструктор ZipEntry передай строку, содержащую имя новой записи.
        //Имя нужно получить из полного пути source, взять только имя файла и сконвертировать его в String.
        ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());

        //3. Добавь в поток архива созданный элемент архива.
        zipOutputStream.putNextEntry(zipEntry);

        try {
        //4. Перепиши данные из файла, который архивируем в поток архива. Для этого:
        //4.1. Создай поток InputStream для добавляемого файла source, используя метод newInputStream класса Files
        //FileInputStream fis = new FileInputStream(source.toString());
        InputStream fis = Files.newInputStream(source);

        //4.2. Сделай цикл, который будет читать данные из InputStream (созданного в п.4.1), пока они там есть и записывать их в
        // ZipOutputStream (созданный в п.1)
        int count = 0; //переменная для записи байтов
        byte[] buffer = new byte[1024]; //размер буфера
        while ((count = fis.read(buffer)) != -1) //пока есть данные
            zipOutputStream.write(buffer, 0, count); //пишем буфер откуда и докуда (с архивацией)

        //Files.copy(file.toPath(), zipOutputStream);

        //4.3. Закрой InputStream, сделай это с помощью try-with-resources
        //5. Закрой элемент архива у потока архива - некорректное требование
        //6. Закрой поток архива, сделай это также с помощью try-with-resources
            fis.close();
            zipOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }



}
