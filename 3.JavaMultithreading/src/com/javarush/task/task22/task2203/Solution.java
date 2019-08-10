package com.javarush.task.task22.task2203;

/* 
Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.


Требования:
1. Класс TooShortStringException должен быть потомком класса Exception.
2. Метод getPartOfString должен принимать строку в качестве параметра.
3. В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
4. Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int count = 1;
        String otvet;

        try {
            if (string == null) throw new TooShortStringException();
            int start = string.indexOf("\t");
            int end = string.length();

            for (int i = start+1; i < string.length(); i++) {
                if (string.charAt(i) == '\t'){
                    count++;
                    if (count == 2) end = i;
                }
            }
            if (count < 2) throw new TooShortStringException();
            else otvet = string.substring(start+1, end);
            return otvet;
        } catch (NullPointerException e) {
            throw new TooShortStringException();
        }

    }


    public static class TooShortStringException extends Exception {
        public TooShortStringException() {
            super();
        }

    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
