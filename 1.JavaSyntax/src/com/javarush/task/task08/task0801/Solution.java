package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.Iterator;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        set.add("арбуз");
        set.add("банан");
        set.add("вишня");
        set.add("груша");
        set.add("дыня");
        set.add("ежевика");
        set.add("жень-шень");
        set.add("земляника");
        set.add("ирис");
        set.add("картофель");

    //получение итератора для множества
    Iterator<String> iterator = set.iterator();
        
    while (iterator.hasNext()){
       System.out.println(iterator.next()); 
       
    } // while
//System.out.println(set);
    }
}
