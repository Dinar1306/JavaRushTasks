package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.Properties;

/* 
Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуй логику записи в файл и чтения из файла для карты properties.


Требования:
1. Метод fillInPropertiesMap должен считывать данные с консоли.
2. Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
3. Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
4. Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
5. Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.

=================

Решать задачу надо с применением экземпляра класса Properties и его методов:
myprop.setProperty(key, value); // так вносятся ключи и значения, по паре за раз
myprop.putAll(someHashMap); //так вносится целиком HashMap !эту команду я не проверил!
myprop.store(outputStream,null); //так все это выгружается в файл
myprop.load(inputStream); //так из файла вычитывается в экземпляр Properties

Далее важный! момент, на сколько я понял, Properties хранит объекты и данные вычитывает именно как объекты, потому чтоб эти данные из Properties загрузить в HashMap их попутно надо привести к типу String в нашем случае.
for (String name : myprop.stringPropertyNames()) {
            someHashMap.put(name, property.getProperty(name));
        }

мне больше нравится в виде лямбда-выражения
myprop.forEach((k,v)->someHashMap.put(k.toString(),v.toString()));

Это необходимый минимум того что нужно знать о классе Properties для решения задачи.
Ответить
+3
Максим25 уровень, Минск
25 апреля, 01:56
Спасибо!
myprop.putAll(someHashMap); // записало целиком.

*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);
        load(fileInputStream);


        reader.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);            //команда для заполнения Properties файла из мапа
        prop.store(outputStream, null);     // сохранение
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream); // гтовый метод класса Properties
        for (String name : prop.stringPropertyNames()) {
            properties.put(name, prop.getProperty(name));
        }

        //считываем все байты разом
        //byte[] strByte = inputStream.readAllBytes();

            //Каждая строка файла обычно содержит один «параметр», который состоит из пары объектов строкового типа «ключ» (имя параметра) — «значение»,
            //записанной в одном из следующих форматов: ключ1=значение1, ключ2 = значение2, ключ3:значение3 и ключ4 : значение4

//        String str = new String(strByte, "UTF-8"); //создаем строку из массива байтов
//        Pattern pattern = Pattern.compile("\r\n");             //делим на подстроки
//        String[] values = pattern.split(str);
//        pattern = Pattern.compile(".+(=|:)");                    //шаблон "делим на ключ-значение"
//        for (int i = 0; i < values.length-1; i++){
//            String[] propers = pattern.split(values[i]);       //делим по шаблону
//            // заполняем Map из .properties КЛЮЧ/ЗНАЧЕНИЕ
//            properties.put(propers[0], propers[1]);
//        }//for i


    }

    public static void main(String[] args) throws Exception {
        new Solution().fillInPropertiesMap();
    }
}
