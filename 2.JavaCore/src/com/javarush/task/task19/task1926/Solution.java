package com.javarush.task.task19.task1926;

/* 
Перевертыши

1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
3. Закрыть потоки.

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА


Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль все символы из файла в обратном порядке.
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String fileName = br.readLine();
            FileReader fr = new FileReader(fileName);
            BufferedReader fileReader = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = fileReader.readLine()) != null){
                sb.append(line + "\n"); //readLine считывает без конца строки
                reverseOut(sb.toString()); //либо System.out.print(sb.reverse());
                sb.delete(0,sb.length());

            }

        br.close();
        fr.close();
        fileReader.close();
    }

    public static void reverseOut(String s) {
        for (int i = s.length()-1; i>=0; i--) {
            System.out.print(s.charAt(i));
        }
    }
}
