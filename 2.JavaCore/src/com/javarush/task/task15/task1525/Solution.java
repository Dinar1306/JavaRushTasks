package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.nio.charset.StandardCharsets;



/* 
Файл в статическом блоке
1. Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.


Требования:
1. Константа FILE_NAME не должна быть пустой.
2. В статическом блоке все строки из файла с именем FILE_NAME должны быть добавлены по-отдельности в список lines.
3. Поле FILE_NAME НЕ должно быть final.
4. Класс Solution должен содержать список lines.
*/

public class Solution {



    public static List<String> lines = new ArrayList<String>();

    static {
        List<String> tempLines = new ArrayList<String>();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(Statics.FILE_NAME), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                /*if (!line.equals(""))*/ tempLines.add(line);
            }
        } catch (IOException e) {
            // log error
        }
        lines = tempLines;
    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
