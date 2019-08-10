package com.javarush.task.task22.task2209;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
В методе main считай с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставь все слова в таком порядке, чтобы последняя буква данного слова совпадала
с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
Вывести полученную строку на экран.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
/*    private static ArrayList<String> resultList = new ArrayList<String>();
    public static ArrayList<String> list;
    private static int step = 0;*/

    public static void main(String[] args) throws IOException {

        //Читаем файл
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        //String fileName = "D:\AMD\tt.txt";
        if (fileName == null) System.exit(1);
        reader.close();
        Path path = Paths.get(fileName);
        List<String> lines = Files.readAllLines(path, Charset.forName("utf-8"));
        String[] words;
        if (!lines.isEmpty()) {
            words = lines.get(0).split(" ");
        } else words = null;

        //Решаем задачу. Принимаем, что во входной последовательности слов ОБЯЗАТЕЛЬНО будет цепочка, включающая все доступные слова
        StringBuilder result = getLine(words);

        //Ответ на консоль
        System.out.println(result.toString());
    }

/*    public static StringBuilder getLine(String... words) {
        // Проверка не некорректные входные условия метода
        if ( (words == null) || ( words.length == 0) ) return new StringBuilder();

        StringBuilder result = new StringBuilder();


        list = new ArrayList<>(Arrays.asList(words));

        // Пускаем один цикл по всем возможным началам цепочки. Если хоть 1 цепочку находим - завершаем
        for (int k = 0; k < list.size(); k++) {
            if (resultList.size() == Solution.list.size()) break;
            resultList.clear();
            resultList.add(list.get(k));
            ArrayList<String> newList = new ArrayList<String>(list);
            newList.remove(k);

            //Запускаем рукурсию для выбранного начала цепочки
            recurFind(newList, 0, resultList.get(0));
        }

        //Выводим найденный результат
        boolean isFirst = true;
        for (String entry : resultList) {
            if (!isFirst) {
                result.append(" ");
            } else isFirst = false;
            result.append(entry);

        }
        return result;
    }

    private static void recurFind(ArrayList<String> list, int index, String lastWordInChain) {
        //Выполняем рекурсивный поиск цепочки. Если найден конечный элемент цепочки, но использованы еще не все слова, откатываемся на один шаг сбора цепочки назад
        for (int j = 0; j < list.size(); j++) {
            // Учитываем различный регистр букв
            if (String.valueOf(lastWordInChain.charAt(lastWordInChain.length()-1)).toLowerCase().equals(String.valueOf(list.get(j).charAt(0)).toLowerCase())) {
                step++;
                if (resultList.size() > step) resultList.set(step, list.get(j));
                else resultList.add(list.get(j));
                String result = list.get(j);
                ArrayList<String> listNew = new ArrayList<String>(list);
                listNew.remove(j);
                recurFind(listNew, 0, result);
                //Проверяем, если рекурсия не смогла собрать цепочку до конца, то пробуем найти на этом же уровне рекурсии другой элемент цепочки
                // т.е., например, для списка слов КА АА АБ АВ для цепочки КА АА на следующем месте может стоять как АБ, так и АВ (следующее слово)
                if (resultList.size() != Solution.list.size()) {
                    step--;
                } else break;
            }
        }
    }*/

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0)
        { return new StringBuilder(); }
        if ("".equals(words[0]) || words.length == 1)
        {return new StringBuilder(words[0]); }

        StringBuilder result = new StringBuilder();

        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < words.length; i ++)
            if (!words[i].equals(""))
                list.add(words[i]);
        while (!isOK(list))
        {
            Collections.shuffle(list);
        }
        for (String s : list)
            result.append(s+ " ");
        result.deleteCharAt(result.length()-1);
        return result;
    }
    public static boolean isOK(ArrayList<String> list)
    {
        for (int i = 0; i < list.size()-1; i++)
        {
            String first = list.get(i);
            String second = list.get(i+1);
            first = first.toLowerCase();
            second =second.toLowerCase();
            if (first.charAt(first.length()-1)!=second.charAt(0))
                return false;
        }
        return true;
    }


}
