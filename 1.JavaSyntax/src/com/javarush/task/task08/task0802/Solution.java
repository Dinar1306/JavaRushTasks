package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("арбуз", "ягода");
        map.put("банан", "трава");
        map.put("вишня", "ягода");
        map.put("груша", "фрукт");
        map.put("дыня", "овощ");
        map.put("ежевика", "куст");
        map.put("жень-шень", "корень");
        map.put("земляника", "ягода");
        map.put("ирис", "цветок");
        map.put("картофель", "клубень");
        
        Iterator<HashMap.Entry<String, String>> iterator = map.entrySet().iterator();

    while (iterator.hasNext())
    {
        //получение «пары» элементов
        HashMap.Entry<String, String> pair = iterator.next();
        String key = pair.getKey();            //ключ
        String value = pair.getValue();        //значение
        System.out.println(key + " - " + value);
    }
    
    }
}
