package com.javarush.task.task26.task2601;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {
    static int med;
    static Integer[] arr_out;
    public static void main(String[] args) {

/*
        //для проверки
        Integer[] arr = {13, 8, 15, 5, 17};
        arr_out = sort(arr);
        for (int i: arr_out) {
            System.out.print(i+", ");
        }
        System.out.println("mediana: "+ med);
*/

    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here

        // получаем медиану
        // сортируем массив. И если нечетное кол-во элементов, то средний, если четное - то среднее между центральными
        Arrays.sort(array);
        int len = array.length;
        int x = len % 2;
        int y = len / 2;
        int mediana;
        if (x != 0) {
            mediana = array[y];}                        //для нечетного кол-ва эл.
        else {
            mediana =  (array[y] + array[y - 1]) / 2;   //для четного кол-ва эл.
        }
        med = mediana;

        //готовим компаратор
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1 - mediana) - Math.abs(o2 - mediana); // сравниваем относительно медианы
            }
        };

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(array)); // готовим list для сравнения в Collections
        Collections.sort(list, comp);                                    // сравниваем по компаратору comp
        Integer[] rez = list.toArray(new Integer[list.size()]);          // список в массив
        return rez;


    }
}
