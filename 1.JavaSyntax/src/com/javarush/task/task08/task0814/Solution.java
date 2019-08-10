package com.javarush.task.task08.task0814;

import java.util.HashSet;
import java.util.Set;
import java.util.*;

/* 
Больше 10? Вы нам не подходите
*/

public class Solution {
    public static HashSet<Integer> createSet() {
        //напишите тут ваш код
        Set<Integer> set = new HashSet<Integer>();
        for (int i=0; i<20; i++){
            Random randNumber = new Random(50);
            int iNumber = randNumber.nextInt();
            set.add(iNumber);
        }
        return (HashSet<Integer>)set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set) {
        //напишите тут ваш код
        Iterator iterator = set.iterator(); //создать итератор по множеству set
        while (iterator.hasNext()){  //Пока есть следующая запись в множестве
            Integer i = (Integer) iterator.next(); //создать ссылку i типа Integer и присвоить ей значение следующей записи из множества
            if (i > 10){ // проверка значения i
              iterator.remove(); // удалить запись из множества
            }
        }
        return set;
    }

    public static void main(String[] args) {
        System.out.println(removeAllNumbersMoreThan10(createSet()));
    }
}
