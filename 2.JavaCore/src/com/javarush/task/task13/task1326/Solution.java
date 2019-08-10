package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.

Пример ввода:
5
8
11
3
2
10

Пример вывода:
2
8
10


Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла(FileInputStream).
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = null;
        try {
            FileInputStream fis = new FileInputStream(br.readLine());
            sc = new Scanner(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Integer> nums = new ArrayList<Integer>();

        while (sc.hasNext())
        {
            String x = sc.next();
            int n = Integer.parseInt(x);
            if (n % 2 == 0) nums.add(n); //  и заносим в список если четный
            //System.out.println(nums);
        }
        //System.out.println();
        sc.close();
        br.close();

        Collections.sort(nums); //сортируем обычно

        for (Integer p : nums) {
            System.out.println(p); // выводим на экран
        }

        //System.out.println(nums); // выводим на экран
    }
}
/*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //создаем поток чтения
        String filename = "D:/OneDrive/JR/" + br.readLine(); //читаем имя файла
        ArrayList<Integer> nums = new ArrayList<Integer>();
        try {
            FileInputStream fis = new FileInputStream(filename); //читаем файл
            //sc = new Scanner(fis); // создаем сканер для файла
            while (fis.available()>0) // читаем
            {
                //data=Character.getNumericValue(inStream.read());
                int n = fis.read(); //
                if (n % 2 == 0) nums.add(n); //  и заносим в список если четный
            }
            fis.close();           // закрывем поток
        } catch (IOException e) {
            e.printStackTrace();
        }




        //Collections.sort(nums, (a, b) -> b.compareTo(a)); // сортируем, лямбда выражение
        Collections.sort(nums); //сортируем обычно

        System.out.println(nums); // выводим на экран


        br.close();     // закрывем поток


    }*/

