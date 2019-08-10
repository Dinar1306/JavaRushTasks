package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
Ввести с клавиатуры дату в формате "08/18/2013"
Вывести на экран эту дату в виде "AUG 18, 2013".
Воспользоваться объектом Date и SimpleDateFormat.


Требования:
1. Программа должна считывать данные с клавиатуры.
2. В программе должна быть объявлена переменная типа SimpleDateFormat.
3. В программе должна быть объявлена переменная типа Date.
4. Все переменные должны быть проинициализированы.
5. Программа должна выводить данные на экран.
6. Вывод должен соответствовать заданию.
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        /*
        Date date = new Date();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        date = br.readLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat(date);
        System.out.println("Constructor 1: " + dateFormat.format( date ) );
        */
        
        Date date = new Date(new BufferedReader(new InputStreamReader(System.in)).readLine());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(dateFormat.format(date).toUpperCase());
    }
}
