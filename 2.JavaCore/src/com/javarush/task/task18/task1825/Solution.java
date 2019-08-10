package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].

Например, Lion.avi.

В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        Map treeMap = new TreeMap<Integer, Byte[]>(); // для складывания массивов байтов файлов в сортированном порядке (по номеру)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName2 = ""; //куда писать итоговый файл
        int counter = 0; // сколько частей
        String fileName = reader.readLine(); // получаем имя файла с консоли
        while (!fileName.equals("end")) {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName)); // создаем поток чтения файла
            byte[] buffer = new byte[inputStream.available()]; //читаем второй файл
            if (inputStream.available() > 0) {  //читаем весь файл одним куском
                inputStream.read(buffer);
            }
            // парсим название файла на номер
            if (fileName2==""){
                String bigFileName = fileName.split(".part")[0]; //берется первый элемент
                fileName2 = bigFileName;
            }
            String fileNumber = fileName.split(".part")[1];
//            String[] podstroki = fileName.split("."); // делим имя файла на части
//            if (fileName2=="") {fileName2 = podstroki[0]+"."+podstroki[1];} // если нет названия, то получаем его
//            StringBuffer sb = new StringBuffer(podstroki[2]); // берем часть с "partN"
//            sb.replace(0, 3, ""); // Обрезаем "part"
            int position = Integer.parseInt(fileNumber); // получаем номер
            treeMap.put(position, buffer); //  вносим буфер в tree по номер(ключ)
            counter++;
            fileName = reader.readLine(); // получаем имя след.файла с консоли
            inputStream.close();
        } // while end
        //FileOutputStream outputStream = new FileOutputStream(fileName2); // готовим поток вывода
        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileName2));
        // Получаем набор элементов
        Set<Map.Entry<Integer, byte[]>> set = treeMap.entrySet();
        // Перебираем набор и пишем в файл
        for (Map.Entry<Integer, byte[]> me : set) {
            outputStream.write(me.getValue());
        }
        outputStream.close();

    }
}
