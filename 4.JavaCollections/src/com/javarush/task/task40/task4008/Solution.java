package com.javarush.task.task40.task4008;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.time.temporal.WeekFields;
import java.util.Locale;

/* 
Работа с Java 8 DateTime API
Выполни задание, используя Java 8 DateTime API.
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов)
и выводить ее в консоль в соответствии с примером:

1) Для "9.10.2017 5:56:45" вывод должен быть:
День: 9
День недели: 1
День месяца: 9
День года: 282
Неделя месяца: 3
Неделя года: 42
Месяц: 10
Год: 2017
AM или PM: PM
Часы: 5
Часы дня: 5
Минуты: 56
Секунды: 45

2) Для "21.4.2014":
День: 21
День недели: 1
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 4
Год: 2014

3) Для "17:33:40":
AM или PM: PM
Часы: 5
Часы дня: 17
Минуты: 33
Секунды: 40


Требования:
1. Если в метод printDate передана дата в формате "дата время", он должен вывести: День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год, AM или PM, Часы, Часы дня, Минуты, Секунды.
2. Если в метод printDate передана дата в формате "дата", он должен вывести: День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год.
3. Если в метод printDate передана дата в формате "время", он должен вывести: AM или PM, Часы, Часы дня, Минуты, Секунды.
4. Используй статический метод parse классов LocalDate и LocalTime.
*/

public class Solution {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        //напишите тут ваш код
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy H:m:s");

            LocalDate localDate = LocalDate.parse(date, formatter);
            LocalTime localTime = LocalTime.parse(date, formatter);

            printDate(localDate);
            printTime(localTime);

        } catch (DateTimeParseException e) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.y");
                LocalDate localDate = LocalDate.parse(date, formatter);
                printDate(localDate);

            }catch (DateTimeParseException e1) {
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m:s");
                    LocalTime localTime = LocalTime.parse(date, formatter);
                    printTime(localTime);
                }catch (DateTimeParseException e2) {
                    System.out.println("Error! Unparseable date: " + date);
                }
            }
        }
    }

    private static void printTime(LocalTime localTime) {
        if (localTime.getHour() > 12) {
            System.out.println("AM или PM: PM");
            System.out.println("Часы: " + (localTime.getHour() - 12));
        }
        else {
            System.out.println("AM или PM: AM");
            System.out.println("Часы: " + localTime.getHour());
        }

        System.out.println("Часы дня: " + localTime.getHour());
        System.out.println("Минуты: " + localTime.getMinute());
        System.out.println("Секунды: " + localTime.getSecond());

    }

    private static void printDate(LocalDate localDate) {
        System.out.println("День: "+localDate.getDayOfMonth());
        System.out.println("День недели: "+localDate.getDayOfWeek().getValue());
        System.out.println("День месяца: "+localDate.getDayOfMonth());
        System.out.println("День года: "+localDate.getDayOfYear());

        System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
        System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));

        System.out.println("Месяц: "+localDate.getMonthValue());
        System.out.println("Год: "+localDate.getYear());
    }

}



