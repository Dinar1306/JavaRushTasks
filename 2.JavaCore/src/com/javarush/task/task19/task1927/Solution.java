package com.javarush.task.task19.task1927;

/* 
Контекстная реклама

В методе main подмени объект System.out написанной тобой реадер-оберткой.
Твоя реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а.
Вызови готовый метод printSomething(), воспользуйся testString.
Верни переменной System.out первоначальный поток.

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth


Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран строки: "first","second","third","fourth","fifth".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream (используй PrintStream c конструктором принимающим ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строки(вставлять контекстную рекламу) выведенные методом printSomething() согласно заданию, и выводить её в консоль.
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream defaultOut = System.out; //Сохранить изначальное значение переменной System.out
        ByteArrayOutputStream outputStream  = new ByteArrayOutputStream(); //Создаем динамический массив
        PrintStream ps = new PrintStream(outputStream); //создаем адаптер к классу PrintStream
        System.setOut(ps); //Устанавливаем его как текущий System.out
        //печатаем
        testString.printSomething();
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();
        System.setOut(defaultOut); //Возвращаем все как было

        //String reg = String.valueOf((char)13)+String.valueOf((char)10);
        String [] lines = result.split(System.lineSeparator());

        for (int i = 0 ; i<lines.length; i++) {
            System.out.println(lines[i]);
            if ((i+1)%2==0) System.out.println("JavaRush - курсы Java онлайн");
        }

        //Когда нужно будет вернуть обратно:
        //System.setOut(defaultOut);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
