package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
Есть класс кот - Cat, с полем "имя" (String).
Создать словарь Map<String, Cat> и добавить туда 10 котов в виде "Имя"-"Кот".
Получить из Map множество(Set) всех котов и вывести его на экран.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. Метод createMap должен создавать новый объект HashMap.
3. Метод createMap должен добавлять в словарь 10 котов в виде «Имя»-«Кот».
4. Метод createMap должен возвращать созданный словарь.
5. Метод convertMapToSet должен создать и вернуть множество котов, полученных из переданного словаря.
6. Программа должна вывести всех котов из множества на экран.
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        Map<String, Cat> manyCats = new HashMap<String, Cat>();
        manyCats.put("Мурзик1", new Cat("Мурзик1"));
        manyCats.put("Мурзик2", new Cat("Мурзик2"));
        manyCats.put("Мурзик3", new Cat("Мурзик3"));
        manyCats.put("Мурзик4", new Cat("Мурзик4"));
        manyCats.put("Мурзик5", new Cat("Мурзик5"));
        manyCats.put("Мурзик6", new Cat("Мурзик6"));
        manyCats.put("Мурзик7", new Cat("Мурзик7"));
        manyCats.put("Мурзик8", new Cat("Мурзик8"));
        manyCats.put("Мурзик9", new Cat("Мурзик9"));
        manyCats.put("Мурзик10", new Cat("Мурзик10"));
        return manyCats;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        /*
        Set<Cat> koty = new Set<Cat>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Cat> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Cat cat) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Cat> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        };

        for (int i = 0; i<10; i++) {
            koty.add(map.get(i));
        }
        return koty;
        */
        return new HashSet(map.values());
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
