package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел).
Слова вывести в возрастающем порядке, числа - в убывающем.

Пример ввода:
Вишня
1
Боб
3
Яблоко
22
0
Арбуз

Пример вывода:
Арбуз
22
Боб
3
Вишня
1
0
Яблоко


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Выведенные слова должны быть упорядочены по возрастанию.
4. Выведенные числа должны быть упорядочены по убыванию.
5. Метод main должен использовать метод sort.
6. Метод sort должен использовать метод isGreaterThan.
7. Метод sort должен использовать метод isNumber.
=============================================================
Короткое решение, обычная сортировка с добавлением if-ов.
Алгоритм такой:
1) берем первый элемент i массива в цикле
2) берем следующий элемент j массива во втором цикле
3) сравниваем его с предыдущим
- if (если i число и j число)
----if (Integer.parseInt [ j ] > Integer.parseInt [ i ])
-------то меняем их местами
- if (если i не число и j не число)
--- if( isGreaterThan( i , j ) )
-------то меняем их местами

как определить что строка (строка - это не число): if ( !isNumber ( " привет " ) ) выдаст true
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код

        String tempStr;
        for (int i = 0; i<array.length; i++){
            for (int j = i; j<array.length; j++){
                if (isNumber(array[i]) & isNumber(array[j])){
                    if (Integer.parseInt(array[j]) > Integer.parseInt(array[i])){
                        tempStr = array[j];
                        array[j] = array[i];
                        array[i] = tempStr;
                    }
                }

            }
        }

        for (int i = 0; i<array.length; i++){
            for (int j = i; j<array.length; j++){

                if (!isNumber(array[i]) & !isNumber(array[j])){
                    if (isGreaterThan(array[i],array[j])){
                        tempStr = array[j];
                        array[j] = array[i];
                        array[i] = tempStr;
                    }
                }
            }
        }

    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
