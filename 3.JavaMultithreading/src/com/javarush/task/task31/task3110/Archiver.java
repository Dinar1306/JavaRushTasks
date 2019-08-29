package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        //ввести полный путь архива с клавиатуры.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Path path = Paths.get(fileName);

        //Создай объект класса ZipFileManager, передав в него имя файла архива.
        ZipFileManager zipFileManager = new ZipFileManager(path);

        //Запроси пользователя ввести путь к файлу, который будем архивировать.
        String fileToArchive = reader.readLine();

        //Вызови метод createZip у объекта ZipFileManager, передав в него путь для архивации.
        zipFileManager.createZip(Paths.get(fileToArchive));
    }
}
