package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами.

Заполнить список PEOPLE используя данные из файла.
Закрыть потоки.

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013


Требования:
1. Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
2. Программа НЕ должна считывать данные с консоли.
3. Программа должна считывать содержимое файла (используй FileReader).
4. Поток чтения из файла (FileReader) должен быть закрыт.
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
//        int d = 0;
//        int m = 0;
//        int y = 0;
//        Integer test = 0;
//        String name = "";
//        Date dr = new Date();
//        boolean named = false;
//        int count = 0;
//
//        while (reader.ready()) {
//            String[] s = reader.readLine().split(" ");
//
//            for (int i = 0; i<s.length; i++){
//                try {
//                    test = Integer.parseInt(s[i]);
//                } catch (Exception e) {
//                    name = name + s[i]+" ";
//                    named = true;
//                }
//                if (named == true) {
//                    named = false;
//                } else {
//                    count++;
//                    switch (count) {               // некорректный ввод дат
//                        case (1):
//                            dr.setDate(test);
//                            break;
//                        case (2):
//                            dr.setMonth(test-1);
//                            break;
//                        case (3):
//                            dr.setYear(test);
//                            break;
//                    }
//                }
//
//            }
//            count = 0;
//            //добавляем в список  //
//            Person chelovek = new Person(name, dr);
//            PEOPLE.add(chelovek);
//        }
//        reader.close();
        String name = "";
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        while (reader.ready()) {
            String line = reader.readLine();
            name = line.replaceAll("\\d", "").trim();
            date = line.replace(name, "").trim();
            PEOPLE.add(new Person(name, sdf.parse(date)));
        }
        reader.close();
    }
}
