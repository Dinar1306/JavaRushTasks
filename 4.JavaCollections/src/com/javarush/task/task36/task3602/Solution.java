package com.javarush.task.task36.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Найти класс по описанию
Описание класса:
1. Реализует интерфейс List;
2. Является приватным статическим классом внутри популярного утилитного класса;
3. Доступ по индексу запрещен - кидается исключение IndexOutOfBoundsException.
Используя рефлекшн (метод getDeclaredClasses), верни подходящий тип в методе getExpectedClass.


Требования:
1. Метод getExpectedClass должен использовать метод getDeclaredClasses подходящего утилитного класса.
2. Метод getExpectedClass должен вернуть правильный тип.
3. Метод main должен вызывать метод getExpectedClass.
4. Метод main должен вывести полученный класс на экран.
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] arrayOfClasses = Collections.class.getDeclaredClasses();
        for (Class<?> clazz : arrayOfClasses) {
            Class superClazz = clazz.getSuperclass();
            ArrayList<Class> arrayOfSuperClasses = new ArrayList<>();
            while (superClazz != null) {
                arrayOfSuperClasses.add(superClazz);
                superClazz = superClazz.getSuperclass();
            }
            for (Class item : arrayOfSuperClasses) {
                Class<?>[] arrayOfInterfaces = item.getInterfaces();
                for (Class<?> declaredInterface : arrayOfInterfaces) {
                    if (declaredInterface.getSimpleName().equals("List")) {
                        Method[] methods = clazz.getMethods();
                        for (Method method : methods) {
                            if (method.getName().equals("get")) {
                                try {
                                    Constructor<?> constructor = clazz.getDeclaredConstructor();
                                    constructor.setAccessible(true);
                                    List<?> emptyList = (List<?>) constructor.newInstance();
                                    emptyList.get(0);
                                } catch (IndexOutOfBoundsException e) {
                                    return clazz;
                                } catch (Exception e) {
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

//    public static Class getExpectedClass() {
//        try {
//            List list = new ArrayList();
//            Class[] getting  = list.getClass().getClasses();
//            for (int i = 0; i < getting.length; i++) {
//                if (Modifier.isPrivate(getting[i].getModifiers()) && Modifier.isStatic(getting[i].getModifiers())){
//                    return getting[i];
//                }
//            }
//        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException e) {}
//                catch (InvocationTargetException e){
//                    if (e.getCause().toString().contains("IndexOutOfBoundsException")) return clazz;
//                }
//        return null;
//    }

    public static boolean isImplementingList(Class<?> clazz) {
        ArrayList<Class<?>> classInterfaces = new ArrayList<>(Arrays.asList(clazz.getInterfaces()));
        ArrayList<Class<?>> parentInterfaces = new ArrayList<>(Arrays.asList(clazz.getSuperclass().getInterfaces()));
        return classInterfaces.contains( List.class.isAssignableFrom(clazz)) || parentInterfaces.contains( List.class.isAssignableFrom(clazz));
    }
}
