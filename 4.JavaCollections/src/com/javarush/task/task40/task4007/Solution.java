package com.javarush.task.task40.task4007;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* 
Работа с датами
Реализуй метод printDate(String date).
Он должен в качестве параметра принимать дату (в одном из 3х форматов) и выводить ее в консоль в соответствии с примером:

1) Для "21.4.2014 15:56:45" вывод должен быть:
День: 21
День недели: 1
День месяца: 21
День года: 111
Неделя месяца: 4
Неделя года: 17
Месяц: 4
Год: 2014
AM или PM: PM
Часы: 3
Часы дня: 15
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

Используй класс Calendar.


Требования:
1. Если в метод printDate передана дата в формате "дата время", он должен вывести: День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год, AM или PM, Часы, Часы дня, Минуты, Секунды.
2. Если в метод printDate передана дата в формате "дата", он должен вывести: День, День недели, День месяца, День года, Неделя месяца, Неделя года, Месяц, Год.
3. Если в метод printDate передана дата в формате "время", он должен вывести: AM или PM, Часы, Часы дня, Минуты, Секунды.
4. Используй статический метод getInstance класса Calendar для получения календаря.
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
        date=date.trim();
        DateFormat dateFormat = null;
        String rezult = "";

        try {
            Calendar calendar = Calendar.getInstance();

            if (date.contains(":")&date.contains(".")){ //если дата-время
                dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                calendar.setTime(dateFormat.parse(date));
                rezult = getDateFromCalendar(calendar) + "\n"+ getTime(calendar);
            } else if(date.contains(".")){ ////если дата
                dateFormat = new SimpleDateFormat("dd.MM.yyyy");
                calendar.setTime(dateFormat.parse(date));
                rezult = getDateFromCalendar(calendar);
            } else { ////если время
                dateFormat = new SimpleDateFormat("HH:mm:ss");
                calendar.setTime(dateFormat.parse(date));
                rezult = getTime(calendar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(rezult);
    }

    private static String getDateFromCalendar(Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("День: ").append(calendar.get(Calendar.DAY_OF_MONTH)).append("\n");

        DateFormat dateFormat = new SimpleDateFormat("E");
        int dayOfWeekEuro = calendar.get(Calendar.DAY_OF_WEEK ) == 1 ? 7 : calendar.get(Calendar.DAY_OF_WEEK )-1;
        stringBuffer.append("День недели: ").append(String.valueOf(dayOfWeekEuro)).append("\n");
        stringBuffer.append("День месяца: ").append(calendar.get(Calendar.DAY_OF_MONTH  )).append("\n");
        stringBuffer.append("День года: ").append(calendar.get(Calendar.DAY_OF_YEAR)).append("\n");
        stringBuffer.append("Неделя месяца: ").append(calendar.get(Calendar.WEEK_OF_MONTH)).append("\n");
        stringBuffer.append("Неделя года: ").append(calendar.get(Calendar.WEEK_OF_YEAR)).append("\n");
        stringBuffer.append("Месяц: ").append(calendar.get(Calendar.MONTH ) +1).append("\n");
        stringBuffer.append("Год: ").append(calendar.get(Calendar.YEAR));
        return stringBuffer.toString();
    }

    private static String getTime(Calendar calendar) {
        StringBuffer stringBuffer = new StringBuffer();
        DateFormat dateFormat = new SimpleDateFormat("a");
        stringBuffer.append("AM или PM: ").append(dateFormat.format(calendar.getTime())).append("\n");
        stringBuffer.append("Часы: ").append(calendar.get(Calendar.HOUR)).append("\n");
        stringBuffer.append("Часы дня: ").append(calendar.get(Calendar.HOUR_OF_DAY)).append("\n");
        stringBuffer.append("Минуты: ").append(calendar.get(Calendar.MINUTE)).append("\n");
        stringBuffer.append("Секунды: ").append(calendar.get(Calendar.SECOND));
        return stringBuffer.toString();
    }
}
