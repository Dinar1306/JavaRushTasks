package com.javarush.task.task40.task4012;

import java.time.*;
import java.time.chrono.ChronoLocalDateTime;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoUnit;

/* 
Полезные методы DateTime API
В Java 8 DateTime API реализовано множество классов и методов, которые существенно упрощают работу со временем и датами.

Реализуем несколько простых методов, чтобы познакомиться с ними поближе.

1) Метод isLeap должен принимать дату и возвращать true, если год является високосным, иначе - false.
2) Метод isBefore должен принимать дату и возвращать true, если она предшествует текущей дате, иначе - false.
3) Метод addTime должен возвращать полученное в качестве параметра время, увеличенное на n СhronoUnit.
4) Метод getPeriodBetween должен принимать две даты и возвращать временной промежуток между ними. Помни, что в метод Period.between необходимо передать сначала меньшую, а затем большую дату.


Требования:
1. Метод isLeap должен принимать дату и возвращать true, если год является високосным, иначе - false.
2. Метод isBefore должен принимать дату и возвращать true, если она предшествует текущей дате, иначе - false.
3. Метод addTime должен возвращать полученное в качестве параметра время, увеличенное на n СhronoUnit.
4. Метод getPeriodBetween должен принимать две даты и возвращать временной промежуток между ними.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isLeap(LocalDate date) { //true, если год является високосным
        return date.isLeapYear();
    }

    public static boolean isBefore(LocalDateTime dateTime) { //true, если она предшествует текущей дате
//        Clock clock = Clock.system(ZoneId.of("Europe/Moscow"));
//        ZonedDateTime zdt = ZonedDateTime.now(clock);
//        ChronoLocalDateTime dt1 = IsoChronology.INSTANCE.localDateTime(zdt);
//        return dateTime.isBefore(dt1);

        LocalDateTime localDateTimeNow = LocalDateTime.now();
        return dateTime.isBefore(localDateTimeNow);

    }

    public static LocalTime addTime(LocalTime time, int n, ChronoUnit chronoUnit) { //увеличенное на n СhronoUnit
        //chronoUnit.addTo(time, n);
        LocalTime lt = time.plus(n, chronoUnit);
        return lt;
    }

    public static Period getPeriodBetween(LocalDate firstDate, LocalDate secondDate) { //возвращать временной промежуток между ними
        if (firstDate.isBefore(secondDate))
            return Period.between(firstDate, secondDate);
        else return Period.between(secondDate, firstDate);
    }
}
