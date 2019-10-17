package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<K, V>();   //TODO add your code here
    //cache должно быть инициализировано объектом типа WeakHashMap<K, V> cache


    //Метод getByKey должен возвращать объект из кеша.
    //Метод getByKey должен добавлять объект в кеш если его там нет.
    public V getByKey(K key, Class<V> clazz) throws Exception {
        //Если объекта не существует в кэше, то добавьте в кэш новый экземпляр используя рефлексию, см. пункт а).
        if (!cache.containsKey(key)){
            //а) публичный конструктор с одним параметром типа K;
            Constructor constructor = clazz.getConstructor(key.getClass());
            V obj = (V)constructor.newInstance(key);
            cache.put(key, obj);
            return obj;
        }
        //TODO add your code here
        return cache.get(key); ////Верни объект из cache для ключа key.

    }

    public boolean put(V obj) {
        //TODO add your code here
        //Используя рефлексию получи ссылку на метод, описанный в пункте б)
        try {
            Method metod = obj.getClass().getDeclaredMethod("getKey");
            //Используя рефлексию разреши к нему доступ.
            metod.setAccessible(true);
            //3.3. Используя рефлексию вызови метод getKey у объекта obj, таким образом ты получишь ключ key.
            K key = (K) metod.invoke(obj);
            //3.4. Добавь в кэш пару <key, obj>.
            cache.put(key, obj);
            //return true;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            return false;
        }   //3.5. Верни true, если метод отработал корректно, false в противном случае. Исключения игнорируй.
        return true;
    }

    public int size() {
        return cache.size();
    }
}
