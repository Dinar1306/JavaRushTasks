package com.javarush.task.task30.task3002;

import java.math.BigInteger;

/*
Осваиваем методы класса Integer
Осваиваем методы класса Integer
Используя метод Integer.parseInt(String, int) реализуй логику метода convertToDecimalSystem, который должен переводить
переданную строку в десятичное число и возвращать его в виде строки.


Требования:
1. В классе Solution должен существовать метод convertToDecimalSystem(String), возвращающий String.
2. Метод convertToDecimalSystem(String) должен иметь модификаторы доступа: public, static.
3. Метод convertToDecimalSystem(String) должен вызывать метод Integer.parseInt(String, int).
4. Метод convertToDecimalSystem(String) должен переводить переданную строку в десятичное число и возвращать его в виде строки.
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        Integer i;
        int base = 10;
        if (s.contains("0x")) base = 16;
        else if (s.contains("0b")) base = 2;
        else if ((s.charAt(0))== '0') base = 8;
        if (base == 16 | base == 2) {
            BigInteger bi = new BigInteger(s.substring(2), base);
            i = Integer.parseInt(bi.toString(), 10);
        } else if (base == 8) {
            BigInteger bi = new BigInteger(s.substring(1), base);
            i = Integer.parseInt(bi.toString(), 10);
        }
        else {
            BigInteger bi = new BigInteger(s, base);
            i = Integer.parseInt(bi.toString(), 10);
        }

        return i.toString();
    }
}
