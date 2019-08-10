package com.javarush.task.task22.task2202;

import javax.print.attribute.standard.PrinterState;
import java.util.*;
/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("А и Б и В и Г и Д"));
    }

    public static String getPartOfString(String stroka) {
        String otvet;

        try {
            String string = stroka.trim();
            int start = string.indexOf(" ");
            int end = 0;
            int count = 1;

            for (int i = start+1; i < string.length(); i++) {
                if (string.charAt(i) == ' '){
                    count++;
                    end = i;
                }
                if (count == 5) i = string.length()-1; // выходим из цикла (место 5го пробела минус 1) это конец слова после четвертого пробела
            }
            if (count == 4)  end = string.length()-1;
            if (count < 4) throw new TooShortStringException();
            else otvet = string.substring(start+1, end+1);
            return otvet.trim();
        } catch (NullPointerException e) {
            throw new TooShortStringException();
        }

    }

    public static class TooShortStringException extends RuntimeException{

    }
}
