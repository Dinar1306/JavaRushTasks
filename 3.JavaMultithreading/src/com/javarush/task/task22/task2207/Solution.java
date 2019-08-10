package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Использовать StringBuilder.
Кодировка файла - UTF-8.

Пример содержимого файла
рот тор торт о
о тот тот тот

Вывод:
рот тор
о о
тот тот


Требования:
1. Метод main должен считывать имя файла с клавиатуры.
2. В методе main должен быть использован StringBuilder.
3. В классе Solution должен содержаться вложенный класс Pair с методами equals, hashCode и toString.
Удалять или изменять эти методы нельзя.
4. В классе Pair должен быть объявлен конструктор без параметров (или конструктор по умолчанию).
5. Список result должен быть заполнен корректными парами согласно условию задачи.

*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();// "D:/AMD/tt.txt"; //считываем имя файла с клавы //todo
        FileInputStream inputStream = new FileInputStream(fileName); // задаем поток для чтения
        ArrayList<String> str = new ArrayList<>(); // готовим массив строк для считывания в него текстового файла
        reader = new BufferedReader(new InputStreamReader(inputStream)); // подготовили буфферед ридер
        String line = reader.readLine();
        while (line != null) { // читаем файл построчно
            str.add(line+" ");
            line = reader.readLine();
        }

        StringBuilder strings = new StringBuilder();
        for (String s: str) {
            strings.append(s);
        }
        String vseVstroke = strings.toString().trim(); //весь текст в одной строке

        Pattern pattern = Pattern.compile(" ");
        String[] values = pattern.split(vseVstroke);

        StringBuilder slovo = new StringBuilder();
        String temp;
        //перебираем массив слов
        /*for (int i = 0; i < values.length; i++) {
            for (int j = i+1; j < values.length; j++) {
                slovo.append(values[j]);
                temp = slovo.reverse().toString();
                Pair pair = new Pair();
                pair.first = values[i];
                pair.second = temp;
                Pair tmpPair = new Pair();
                tmpPair.first = pair.second;
                tmpPair.second = pair.first;
                if(!result.contains(tmpPair))
                    result.add(pair);
                slovo.delete(0, slovo.length());
                temp = "";
            }
        }*/

        for(int i = 0; i < values.length; i++){
            String reverseStr = new StringBuilder(values[i]).reverse().toString();
            for(int j = 0; j < values.length; j++){
                if(i == j) continue;
                if(values[j].equals(reverseStr)){
                    Pair pair = new Pair();
                    pair.first = values[i];
                    pair.second = values[j];
                    Pair tmpPair = new Pair();
                    tmpPair.first = pair.second;
                    tmpPair.second = pair.first;
                    if(!result.contains(tmpPair))
                        result.add(pair);
                }
            }
        }

        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {    // конструктор по умолчанию (без параметров)
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                        first == null ? second :
                            second == null ? first :
                                first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
