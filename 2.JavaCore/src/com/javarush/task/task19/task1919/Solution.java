package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0

Требования:
1. Программа НЕ должна считывать данные с консоли.
2. Программа должна считывать содержимое файла (используй FileReader).
3. Поток чтения из файла (FileReader) должен быть закрыт.
4. Программа должна выводить в консоль каждое имя и сумму всех его значений, все данные должны быть отсортированы в возрастающем порядке по имени.
*/

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> sotrudniki = new TreeMap<>();
// код не пашет
//        //File file = new File(args[0]);
//        //создаем объект FileReader для объекта File
//        FileReader fr = new FileReader(args[0]);
//        //создаем BufferedReader с существующего FileReader для построчного считывания
//        BufferedReader reader = new BufferedReader(fr);
//        // считаем сначала первую строку
//        String line = reader.readLine();
//        Pattern pattern = Pattern.compile(" ");
//
//        while (line != null) {
//            String[] values = pattern.split(line);
//
//            //HashMap<String, Integer> map = new HashMap<>();
//
//            for (String t : values) {
//                if (sotrudniki.containsKey(t)) {
//                    sotrudniki.put(t, sotrudniki.get(t) + Double.parseDouble(values[1]));
//
//                } else {
//                    sotrudniki.put(t, Double.parseDouble(values[1]));
//                }
//            }
//
//            // считываем остальные строки в цикле
//            line = reader.readLine();
//        } // while
//        //System.out.println(sotrudniki);

        /////////////////////
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> m = new TreeMap<>();

        while (reader.ready()) {
            String[] s = reader.readLine().split(" ");
            if (m.containsKey(s[0]))
            { m.put(s[0], m.get(s[0])+Double.parseDouble(s[1])); }
            else m.put(s[0], Double.parseDouble(s[1]));
        }
// ниже короткий вариант лябда выражения
//        for (Map.Entry<String, Double> entry: m.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
        reader.close();


        m.forEach((k, v) -> System.out.println(k + " " + v));

    }
}
