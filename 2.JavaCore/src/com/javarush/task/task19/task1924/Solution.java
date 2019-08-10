package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* 
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.


Требования:
1. Класс Solution должен содержать публичное статическое поле map типа Map<Integer, String>, которое должно быть сразу проинициализировано.
2. Программа должна считывать имя файла с консоли (используй BufferedReader).
3. BufferedReader для считывания данных с консоли должен быть закрыт.
4. Программа должна считывать содержимое файла (используй FileReader).
5. Поток чтения из файла (FileReader) должен быть закрыт.
6. Программа должна выводить в консоль все строки из файла, но числа должны быть заменены на слова из словаря map.
7. Класс Solution должен содержать статический блок, в котором добавляются в map тринадцать пар.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    public static void setMap(Map<Integer, String> map) {
        Solution.map = map;
    }

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        String slovo = ""; //временная пустая строка для составления слова из символов
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // объект буферного потока ввода
        String file =  br.readLine();   //имя файла "D:/OneDrive7/OneDrive/JR/file1.txt"; //  //todo
        FileReader reader = new FileReader(file); // готовим читатель файла посимвольно
        while (reader.ready()) //пока есть непрочитанные байты в потоке ввода
        {
            int data = reader.read(); //читаем один символ (char будет расширен до int)
            slovo += (char)data;
        }   //while
        Pattern pattern = Pattern.compile(" ");
        String[] values = pattern.split(slovo);

        for (int i = 0; i < values.length; i++) {
            if(values[i].chars().allMatch( Character::isDigit )) { //если число
                for (Map.Entry entry: map.entrySet()) {             // проходим по мапу
                    int key = (int) entry.getKey();                 // берем кей
                    String value = (String) entry.getValue();       // берем значение
                    //действия с ключом и значением
                    if (Integer.parseInt(values[i])==key) {                  //если цифра равна ключу
                        values[i] = value;            // заменяем цифру на слово по этому ключу  value.equals(values[i])
                        break;   // прерываем цикл - нет необходимости в дальнейшем сравнении
                    }
                } // for map

            }
        }

        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]+" ");
        }
        reader.close();
        br.close();
    }
}
