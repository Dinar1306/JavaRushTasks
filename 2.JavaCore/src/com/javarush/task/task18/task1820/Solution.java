package com.javarush.task.task18.task1820;

/* 
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.

Принцип округления:
3.49 => 3
3.50 => 4
3.51 => 4
-3.49 => -3
-3.50 => -3
-3.51 => -4


*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        String stroka = "";
        String result = "";
        String temp = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();   // имя первого фала //todo "D:/OneDrive/JR/numbers.txt"; //
        String file2 = reader.readLine();   // имя второго файла //todo "D:/OneDrive/JR/numbers2.txt"; //
     //   int i = 0; //счетчик
        FileInputStream fis = new FileInputStream(file1); // поток для чтения первого файла
        byte[] buffer = new byte[fis.available()];         // создаем массив байт соответствующего размера
        while (fis.available() > 0) {
            stroka += (char) fis.read(); // считываем файл до конца в одну строку, переводя байты в char
        }
        fis.close(); // закрываем поток
        String[] values = new String[stroka.length()];
        Pattern pattern = Pattern.compile(" "); // ищем пробелы
        values = pattern.split(stroka);         // формируем массив
        double[] dubs = new double[values.length]; // готовим масив doubles
        BigDecimal[] bigs = new BigDecimal[values.length]; // и BigDecimal
        for (int i = 0; i<dubs.length; i++) {
            dubs[i] = Double.parseDouble(values[i]); // заполняем doubs переводом строк в double
            bigs[i] = new BigDecimal(dubs[i]);      // и заполняем bigs
//            Синтаксис тернарного оператора в Java:
//            результат = выражение ? значение1 : значение2;
            temp = dubs[i] < 0 ? bigs[i].setScale(0, BigDecimal.ROUND_HALF_DOWN).toString() : bigs[i].setScale(0, BigDecimal.ROUND_HALF_UP).toString();
                                    //    знаков после запятой / окр.вниз / окр.вверх
            result = result + temp + " "; // формирование строки
        } // for i
        FileOutputStream fos = new FileOutputStream(file2); // поток для записи второго файла
        byte[] buffer2 = result.getBytes();  // перевод строки в байты
        fos.write(buffer2, 0, buffer2.length); // запись в файл всех байтов разом
        fos.close(); // закрыть поток вывода
    }
}
