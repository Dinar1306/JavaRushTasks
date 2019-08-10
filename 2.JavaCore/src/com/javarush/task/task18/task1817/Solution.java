package com.javarush.task.task18.task1817;

/* 
Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45.
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой.
4. Закрыть потоки.


Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. Посчитай отношение пробелов ко всем символам в файле и выведи в консоль это число.
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, Exception {
       // args = new String[]{"D:/OneDrive/JR/strings2.txt"};
        FileInputStream fis = new FileInputStream(args[0]); //("D:/OneDrive/JR/strings.txt");//todo
        int simvols = 0;
        int probels = 0;
        String result = "";
        String line = "";

        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));

      //  File file = new File(args[0]);
        //создаем объект FileReader для объекта File
       // FileReader fr = new FileReader(file);
       // try (BufferedReader reader = new BufferedReader(fr)) {


            while (line != null) {

                result += line;
                line = reader.readLine();

            //}
        }



//        while (fis.available() > 0) {
//            result += (char) fis.read(); // считываем файл до конца в одну строку, переводя байты в char
//        }
        fis.close(); // закрываем поток

        Pattern pat = Pattern.compile(" "); // регулярка (РВ). Класс не имеет публичных конструкторов, поэтому для создания
        // объекта данного класса необходимо вызвать статический метод compile и передать в качестве первого аргумента строку с РВ
        Matcher mat = pat.matcher(result); //Matcher — класс, который представляет строку, реализует механизм согласования (matching)
        // с РВ и хранит результаты этого согласования (используя реализацию методов интерфейса MatchResult).
        // Не имеет публичных конструкторов, поэтому для создания объекта этого класса нужно использовать метод matcher класса Pattern
        while (mat.find()) { //Но результатов у нас еще нет. Чтобы их получить нужно воспользоваться методом find,
            //который пытается найти подстроку, которая удовлетворяет РВ.
            probels++;
        }
        simvols = result.length();
        Double d= new Double(probels);//first way
        Double d2 = Double.valueOf(simvols);//second way
        System.out.format("%.2f", d/d2*100);
    }
}
