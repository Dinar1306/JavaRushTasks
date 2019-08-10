package com.javarush.task.task22.task2208;

import java.util.ArrayList;
import java.util.Map;

/* 
Формируем WHERE
Сформируй часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.

Пример:
{name=Ivanov, country=Ukraine, city=Kiev, age=null}

Результат:
name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'


Требования:
1. Метод getQuery должен принимать один параметр типа Map.
2. Метод getQuery должен иметь тип возвращаемого значения String.
3. Метод getQuery должен быть статическим.
4. Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
/*        String otvet;
        StringBuilder temp = new StringBuilder();
        ArrayList<String> keys = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
*//*        - сделала проверку на размер params, если он меньше 1 - возвращаем пустую строку
else
        - скопировала все ключи из мапы в ArrayList, и если размер этого ArrayList-а меньше 1 - возвращаем пустую строку
else
        -  stringbuilder-ом составила строку как в условии, попалась на кавычках (апострофах), их добавлять нужно обязательно

        последовательность не важна для валидатора (у меня country, потом city, потом name), делала через Map.Entry<String, String> pair*//*
        if (params.size()<1) return "";
        else
        {
*//*          keys.addAll(params.keySet());
            values.addAll(params.values());
            if (keys.size()<1) return "";
            else
            {
                if ()
                {
                    temp.append(keys.get(0)+" = '"+values.get(0)+"'");
                    for (int i=1; i<keys.size(); i++)
                    {
                        temp.append(" and "+keys.get(i)+" = '"+values.get(i)+"'");
                    }
                }
                //temp.append(keys.get(0)+" = '"+values.get(0)+"' and "+keys.get(1)+" = '"+values.get(1)+"' and "+keys.get(2)+" = '"+values.get(2)+"'");
            }*//*
            for (String key:params.keySet()) {
                if (params.get(key) != null) {
                    temp.append(key + " = '"+ params.get(key)+"' and ");
                }
            }
        }
        otvet = temp.toString();

        return otvet;*/
        StringBuilder sb = new StringBuilder();
        params.entrySet().stream()
                .filter(pair ->
                        pair.getKey() != null
                                &&  pair.getValue() != null
                                && !pair.getKey().isEmpty()
                                && !pair.getValue().isEmpty()
                ).forEach(pair ->
                sb.append(pair.getKey())
                        .append(" = '")
                        .append(pair.getValue())
                        .append("' and ")
        );
        int len = sb.length();
        sb.setLength(len > 4 ? len-5 : 0);
        return sb.toString();
    }
}



