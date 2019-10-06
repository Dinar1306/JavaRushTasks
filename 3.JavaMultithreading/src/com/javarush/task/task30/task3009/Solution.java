package com.javarush.task.task30.task3009;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
Объяви и реализуй логику приватного статического метода Set<Integer> getRadix(String number), в котором нужно определить,
в каких системах счисления (от 2 до 36 включительно) представление числа number (передается в десятичной системе счисления)
является палиндромом и добавить индекс таких систем в результат.
Если переданное число некорректно - возвращай пустой HashSet.
В системах счисления с основанием большим 10 в качестве цифр используются латинские буквы. К примеру, числу 35
в десятичной системе соответствует число "Z" в системе с основанием 36.

Метод main не принимает участие в тестировании.

P.S.: В методе getRadix перехватывай NumberFormatException. Стек-трейс выводить не нужно
Требования:
1. Необходимо объявить приватный статический метод Set<Integer> getRadix(String number).
2. Метод getRadix в случае некорректных входных данных должен возвращать пустой HashSet.
3. Методе getRadix не должен бросать NumberFormatException.
4. Метод getRadix не должен ничего выводить в консоль.
5. Метод getRadix должен возвращать множество согласно условию задачи.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number){
        Set<Integer> integers = new HashSet<Integer>();
        Integer integer;
        String str;
        try {
            //Integer.toString(35, 36)
            //компилятор переводит 35 из 10-ой системы счисления в 36-ую, а потом переводит в строку
            //
            //new BigInteger("35", 36)
            //здесь сначала просто парсится число из строки в конкретной системе счисления в объект BigInteger,
            // т.е. никакой конвертации не происходит. Компилятору сообщается что 35 уже в 36-ой системе счисления.
            // метод toString() у BigInteger по умолчанию выводит числа в десятичной системе счисления
            for (int k = 2; k <= 36; k++) { //перебираем системы счисления
                integer = Integer.parseInt(number); // получаем интежер из переданной строки
                str = Integer.toString(integer, k); // переводим число в систему счисления k, результат в виде строки
                if (isPalindrom(str)) {
                    integers.add(Integer.valueOf(k));
                }
            }
            return integers;
        } catch (NumberFormatException e) {
            //e.printStackTrace();
            return integers = Collections.EMPTY_SET;
        }

    }

    public static boolean isPalindrom (String text){
        boolean ans = false;
        text = text.replaceAll("\\W","");//удаляем все ненужное
        StringBuilder strBuilder = new StringBuilder(text);
        strBuilder.reverse(); //переворачиваем строку
        String invertedText = strBuilder.toString();//присваиваем перевернутую строку

        ans = text.equalsIgnoreCase(invertedText) ;//возвращаем сравнение двух строк вне зависимости от регистра

        return ans;
    }
}