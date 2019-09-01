package com.javarush.task.task31.task3109;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

/* 
Читаем конфиги
Реализовать метод getProperties, который должен считывать свойства из переданного файла fileName.
fileName может иметь любое расширение - как xml, так и любое другое, или вообще не иметь.
Нужно обеспечить корректное чтение свойств.
При возникновении ошибок должен возвращаться пустой объект.
Метод main не участвует в тестировании.

Подсказка: возможно тебе понадобится File.separator.


Требования:
1. Класс Solution должен содержать метод Properties getProperties(String fileName).
2. Метод getProperties должен корректно считывать свойства из xml-файла.
3. Метод getProperties должен корректно считывать свойства из любого другого файла с любым расширением.
4. Метод getProperties должен возвращать пустой объект, если во время чтения свойств возникла ошибка.
*/
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties prop = new Properties();
        //место последнего разделителя в строке
        //System.out.println(File.separator);
        //имя файла
        //int sep = fileName.lastIndexOf(File.separator);
        int sep = fileName.lastIndexOf("/")+1;
        String fn = fileName.substring(sep);

        try {
            //Path path = path.resolve();
            //получаем файл со свойствами
            File file = new File(fileName);

            if (file.exists()){

                if (fileName.endsWith("xml")) // xml
                {
                    String key = ""; //ключ для печати
                    String val = ""; //значение для печати
                    List<String> xmlStrings = Files.readAllLines(Paths.get(fileName));
                   // System.out.println(xmlStrings);
                    for (String s : xmlStrings) {
                        if (s.contains("key=")){
                            int keyStart = s.indexOf("=")+2; //первая буква ключа
                            int keyEnd   = s.indexOf(">")-1; // позиция последней буквы ключа
                            key = s.substring(keyStart, keyEnd);

                            int valStart = keyEnd+2; //первая буква значения
                            int valEnd   = s.indexOf("/")-1; // позиция последней буквы значения
                            val = s.substring(valStart, valEnd);

                            //System.out.println(key+"="+val); // печать выводится верно, добавляем все в Prooerties
                            prop.put(key, val);
                        }


                    }
                } // if xml


                else if (fileName.endsWith("txt")) // txt
                {
                    //создаем объект Properties и загружаем в него данные из файла.
                    //Properties properties = new Properties();
                    prop.load(new FileReader(file));


//                    //проходимся по всем ключам и печатаем все их значения на консоль
//                    for (String key : properties.stringPropertyNames()){
//                        System.out.println(properties.get(key));
//                    }
                } // if txt
                 else {
                    prop.load(new FileReader(file));
                }

            }




        }
        catch (Exception e){

        }
        return prop;
    }
}
