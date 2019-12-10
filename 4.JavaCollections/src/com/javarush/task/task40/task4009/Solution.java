package com.javarush.task.task40.task4009;

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

/* 
Buon Compleanno!
Реализуй метод getWeekdayOfBirthday.
Метод должен возвращать день недели на итальянском языке, в который будет (или был) день рождения в определенном году.
Пример формата дат смотри в методе main.

Пример:
1) Для "30.05.1984" и "2015" метод должен вернуть: sabato
2) Для "1.12.2015" и "2016" метод должен вернуть: gioved?

Выполни задание, используя Java 8 DateTime API.


Требования:
1. Используй статический метод parse класса LocalDate.
2. Используй статический метод parse класса Year.
3. Используй локаль Locale.ITALIAN.
4. Метод getWeekdayOfBirthday должен возвращать правильный день недели для передаваемых параметров.
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
//        StringBuilder sb = new StringBuilder();
//        sb.append(birthday.substring(0, birthday.length()-4));
//        sb.append(year);

        Year yearOfQuery = Year.parse(year);


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.M.yyyy");
        LocalDate localDate = LocalDate.parse(birthday, dtf);
        LocalDate localDateY =  localDate.withYear(yearOfQuery.getValue());


        return localDateY.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ITALIAN);
    }
}
