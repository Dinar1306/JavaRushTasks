package com.javarush.task.task34.task3413;

import java.lang.ref.SoftReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();

    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);

        //напишите тут ваш код
        //проверяем softReference на null. Если не равен - возвращаем softReference.get(). Иначе возвращаем null.
        if (softReference != null){
            return softReference.get();
        }
        else return null;
    }

    public AnyObject put(Long key, AnyObject value) {
        SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));

        //напишите тут ваш код
        //так же проверяем softReference на null. Если не равен - создаем объект типа AnyObject и передаем туда значение
        // из softReference. Потом очищаем softReference и возвращаем объект типа AnyObject. Иначе возвращаем null.
        if (softReference != null){
            AnyObject anyObject =  softReference.get();
            softReference.clear();
            return anyObject;
        }
        else return null;
    }

    public AnyObject remove(Long key) {
       // AnyObject anyObject = new AnyObject(key, );
        SoftReference<AnyObject> softReference = cacheMap.remove(key);

        //напишите тут ваш код
        if (softReference != null){
            AnyObject anyObject =  softReference.get();
            softReference.clear();
            return anyObject;
        }
        else return null;
    }
}