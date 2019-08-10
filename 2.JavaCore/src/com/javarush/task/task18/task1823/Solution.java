package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.


Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        while (!fileName.equals("exit")) {
            ReadThread readThread = new ReadThread(fileName);
            readThread.start();
            readThread.join();
            fileName = reader.readLine();
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) throws Exception {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            FileInputStream inputStream = null; // задаем поток для чтения
            try {
                inputStream = new FileInputStream(fileName);
                HashMap<Integer, Integer> hashMap = new HashMap<>();
                while (inputStream.available() > 0) {
                    int data = inputStream.read();
                    if (hashMap.containsKey(data)) {
                        int count = 1 + hashMap.get(data);
                        hashMap.put(data, count);
                    } else {
                        hashMap.put(data, 1);
                    }
                }
                int res = 0;
                for (Integer i : hashMap.values()) { //находим макс. кол-во повторений
                    if (i > res) {
                        res = i;
                    }
                }
                inputStream.close();
                for (Map.Entry<Integer, Integer> i : hashMap.entrySet()) {
                    if (i.getValue() == res) {
                        //System.out.print(i.getKey()+" ");
                        resultMap.put(fileName, i.getKey());
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}