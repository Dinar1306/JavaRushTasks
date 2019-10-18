package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <K, V extends Convertable<K>> Map<K, V> convert(List<V> list) {
        Map<K, V> result = new HashMap();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            result.put(list.get(i).getKey(), list.get(i));
        }
        return result;
    }
}
