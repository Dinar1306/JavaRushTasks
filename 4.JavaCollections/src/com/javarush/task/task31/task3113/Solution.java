package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
Напиши программу, которая будет считать подробную информацию о папке и выводить ее на консоль.

Первым делом считай путь к папке с консоли.
Если введенный путь не является директорией - выведи "[полный путь] - не папка" и заверши работу.
Затем посчитай и выведи следующую информацию:

Всего папок - [количество папок в директории и поддиректориях]
Всего файлов - [количество файлов в директории и поддиректориях]
Общий размер - [общее количество байт, которое хранится в директории]

Используй только классы и методы из пакета java.nio.

Квадратные скобки [ ] выводить на экран не нужно.


Требования:
1. Метод main должен считывать путь к папке с консоли.
2. Если введенный путь не является директорией - нужно вывести "[полный путь] - не папка" и завершить работу.
3. Используй только классы и методы из пакета java.nio.
4. На консоль должна быть выведена следующая информация: "Всего папок - [количество папок в директории и поддиректориях]".
5. На консоль должна быть выведена следующая информация: "Всего файлов - [количество файлов в директории и поддиректориях]".
6. На консоль должна быть выведена следующая информация: "Общий размер - [общее количество байт, которое хранится в директории]".
*/
public class Solution  extends SimpleFileVisitor<Path> {

    private static int countFolders,
                       countFiles,
                       countSize;


    public static void main(String[] args) throws IOException {
        countFolders = - 1; //При подсчете количества папок, изначальную директорию считать не нужно.

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Path path = Paths.get(fileName);
        if (Files.isDirectory(path)){
            Files.walkFileTree(path, new Solution());
            System.out.printf("Всего папок - %d\r\n", countFolders);
            System.out.printf("Всего файлов - %d\r\n", countFiles);
            System.out.printf("Общий размер - %d\r\n", countSize);
        } else {
            System.out.println(fileName + " - не папка");
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        // cheking
        if (!Files.isDirectory(file))
        {
            countFiles++;
            byte[] content = Files.readAllBytes(file); // размер файла: content.length
            int fileSize = content.length;
            countSize += fileSize;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult  preVisitDirectory(Path file, BasicFileAttributes attrs) throws IOException {
        countFolders++;
        return FileVisitResult.CONTINUE;
    }
}
