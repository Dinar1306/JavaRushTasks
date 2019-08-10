package com.javarush.task.task15.task1527;

import netscape.javascript.JSException;
//import sun.plugin.javascript.navig.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Парсер реквестов
Считать с консоли URL-ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк
Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.

Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double 3.14


Требования:
1. Программа должна считывать с клавиатуры только одну строку.
2. Программа должна выводить данные на экран в соответствии с условием.
3. Программа должна вызывать метод alert с параметром double в случае, если значение параметра obj может быть корректно преобразовано в число типа double.
4. Программа должна вызывать метод alert с параметром String в случае, если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        String URL=new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("^(.*?\\?)","");
        for(String s:URL.split("&"))System.out.print(s.replaceAll("=.*$","")+" ");
        System.out.println();
        for(String s:URL.split("&")){
            if(s.replaceAll("=.*$","").equals("obj")){
                try{
                    alert(Double.parseDouble(s=s.replaceAll("^[^=]*=","")));
                }catch(NumberFormatException e){
                    alert(s);
                }
            }
        }
    }

    //////////////////////////////////////////////
    /*
    Описание строк (добавить +50):
    1. Создаем URL. Считываем. Обрезаем всё что до знака вопроса (включительно)
    2. Сплитим строки по символу & и сразу по этим строкам пробегаемся через for-each. Внутри псевдо-обрезаем правую часть вместе
       с = и выводим на экран содержимое через пробел.
    3. Переходим на следующую строку.
    4. Опять сплитим строки по символу & и сразу по этим строкам пробегаемся через for-each.
    5. Внутри псевдо-обрезав правую часть вместе с = сравниваем, что это obj.
    6.
    7. Обрезаем левую часть до первого знака = (включительно), остаток присваиваем в s. Второе и более вхождение знака = тоже уже
       пойдут в s Если s преобразуется в double, то вызовется нужный alert. Целые числа (без точки) тоже пройдут.
       Всё остальное (с посторонними символами) уйдёт в 9 строку.
    8.
    9. Вызов alert с типом String. Содержимое s уже обработано в блоке try
    10.
    11.
    12.
    По регуляркам есть небольшой список с описанием: http://darkraha.com/rus/dic/regexp.php
    */
    //////////////////////////////////////////////



    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
/*
    char c: url.toCharArray()

    String copyValueOf()*/

///////////////////
// мой код надо чуть доточить
//////////////////

/*

double d = 0.0;
        boolean daNet = false;
        String urlString, printString;
        Map<String, String> map = new LinkedHashMap<String, String>(); // приготовили map
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {

            URL url = new URL(br.readLine()); //считали строку

            urlString = url.getQuery();  // получили полную строку с параметрами
            String urlStr = urlString.toString(); // привели к строке
            String[] partsFull = urlStr.split("&"); // получаем параметры со значениями

            for(String part : partsFull){
                //System.out.println(part);
                String[] parts = part.split("=" ,0); // разделяем параметр - значение (limit=0 - не учитываются пустые строки)
                if (parts.length == 2) map.put(parts[0], parts[1]);
                else if (parts.length == 1) map.put(parts[0], "");
            }

            printString = ""; // готовим строку к печати
            for (Map.Entry<String, String> pair : map.entrySet()) {
                String key = pair.getKey();                      //ключ
                //String value = pair.getValue();                  //значение
                if (key.equals("obj")) {                // если содержит obj
                    for (Map.Entry<String, String> pair2 : map.entrySet()) {
                        System.out.print(pair2.getKey() + " "); // выводим параметры
                    }
                    d = Double.parseDouble(pair.getValue());    // получаем double из строки
                    System.out.println();
                    alert(d);   // выводим в консоль double
                    break; // другие параметры не нужны
                } else {
                    for (Map.Entry<String, String> pair3 : map.entrySet()) {
                        printString = printString + pair3.getKey() + " ";
                    } // for else

                    alert(printString);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


 */