package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Проход по дереву файлов
1. На вход метода main() подаются два параметра.
Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла, который будет содержать результат.
2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и, если понадобится, FileUtils.isExist()).
3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
Все файлы имеют расширение txt.
В качестве разделителя пути используй "/".
Для создания файлов используй конструктор File(String pathname).


Требования:
1. Файл, который приходит вторым параметром в main, должен быть переименован в allFilesContent.txt.
2. Нужно создать поток для записи в переименованный файл.
3. Содержимое всех файлов, размер которых не превышает 50 байт, должно быть записано в файл allFilesContent.txt в отсортированном по имени файла порядке.
4. Поток для записи в файл нужно закрыть.
5. Не используй статические переменные.
*/
public class Solution {
    //public List<String> txtFilesList = new ArrayList();
    public static void listfiles(File path, List<File> filesName) {
        File[] fList = path.listFiles();
        for (File file : fList) {
            if (file.isFile() && file.length() <= 50) {
                filesName.add(file);
            } else if (file.isDirectory()) {
                listfiles(file, filesName);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        FileInputStream fileInputStream = null;
//        FileOutputStream fileOutputStream = null;
//        List<String> txtFilesList = new ArrayList();


        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent()+"/allFilesContent.txt");
        boolean marker = FileUtils.isExist(resultFileAbsolutePath);
        if (marker) {
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        }


        try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(allFilesContent, true))) {


            List<File> filesName = new ArrayList<>();

            listfiles(path, filesName);

            Collections.sort(filesName);

            for (File file : filesName) {
                FileInputStream input = new FileInputStream(file);
                byte[] b = new byte[input.available()];
                input.read(b, 0, b.length);
                output.write(b, 0, b.length);
                output.write("\n".getBytes());
                input.close();
            }


        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        //output.close();



        /*
        try {
            fileInputStream = new FileInputStream(path);
            fileOutputStream = new FileOutputStream(allFilesContent);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }  finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
        */


    }


}
