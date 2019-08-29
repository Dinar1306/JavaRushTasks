package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
Находим все файлы

Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используй очередь, рекурсию не используй.
Верни список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.


Требования:
1. Метод getFileTree должен принимать аргументом String root, по которому нужно найти все вложенные файлы.
2. Метод getFileTree должен возвращать список строк.
3. Нужно реализовать метод getFileTree: найти все файлы по указанному пути и добавить их в список.
4. Метод getFileTree должен быть вызван только 1 раз (рекурсию не использовать).
*/
public class Solution {

    static List<String> filesList = new ArrayList<>();

    public static List<String> getFileTree(String root) throws IOException {
        List<String> fileTree = new ArrayList<>();
        File path = new File(root);
        Queue<File> directories = new LinkedList<>(); //папки перебираются в очереди
        directories.add(path);
        while (directories.size()!=0){
            File[] fList = ((LinkedList<File>) directories).getFirst().listFiles();
            for (File file : fList) {
                if (file.isFile()) {            // если файл, то добавляем в список файлов
                    fileTree.add(file.getAbsolutePath());

                } else {
                    if (file.isDirectory()) {  // если это папка, то добавляем в конец очереди (список папок)
                        ((LinkedList<File>) directories).addLast(file);
                    }
                }
            }
            ((LinkedList<File>) directories).removeFirst(); //прошлись по всей очереди, удаляем первого
        }




        return fileTree;

    }

    public static void main(String[] args) {


        try {
            filesList = getFileTree("D:/OneDrive7/OneDrive/untitled");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String st : filesList) {
            System.out.println(st);
        }
    }
}
