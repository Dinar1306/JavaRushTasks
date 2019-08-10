package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* 
Функциональности маловато!
Задача: Программа вводит с клавиатуры пару (число и строку) и выводит их на экран.
Новая задача: Программа вводит с клавиатуры пары (число и строку), сохраняет их в HashMap.
Пустая строка - конец ввода данных.
Числа могут повторяться.
Строки всегда уникальны.
Введенные данные не должны потеряться!
Затем программа выводит содержание HashMap на экран.
Каждую пару с новой строки.

Пример ввода:
1
Мама
2
Рама
1
Мыла

Пример вывода:
1 Мыла
2 Рама
1 Мама


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. В методе main объяви переменную коллекции HashMap и сразу проинициализируй ee.
4. Программа должна помещать в HashMap пары считанные с клавиатуры.
5. Программа должна выводить на экран содержимое HashMap согласно условию. Ключ и значение разделены пробелом. Каждое значение с новой строки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<String, Integer> temp = new HashMap<>(); // for validator
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        int id;
        String name, tempo;
        boolean konec = false;
        while (true){

            try {
                tempo = reader.readLine();
                if (tempo.isEmpty()){
                    break;
                }
                id = Integer.parseInt(tempo);
            } catch (NumberFormatException e) {
                id = 0;
                //konec = true;
                //e.printStackTrace();
            } catch (IOException e) {
               // e.printStackTrace();
                id = 0;
                //konec = true;
            }
            name = reader.readLine();

            map.put(name, id);
            temp.put(name, id);
        }

        for (HashMap.Entry<String, Integer> pair : map.entrySet()) {
            id = pair.getValue();
            name = pair.getKey();
            System.out.println(id + " " + name);
        }

        //System.out.println("Id=" + id + " Name=" + name);
    }
}
