package com.javarush.task.task35.task3505;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* 
List to Map
Реализуй логику метода convert в классе ConvertableUtil, который должен возвращать словарь, значениями которого
являются элементы переданного cписка, а ключами являются объекты, полученные вызовом интерфейсного метода getKey.

Элементы cписка должны наследоваться от Convertable, который в свою очередь параметризирован каким-то ключом.
Например, ConvertableBook параметризирован String, т.е. ключ в результирующем словаре должен иметь тип - String
ConvertableUser параметризирован Integer, т.е. ключ в результирующем словаре должен иметь тип - Integer

Значения в словаре должны совпадать с элементами Списка.
Смотрите метод main для примера.

Расставьте в методе ConvertableUtil.convert дженерик типы.


Требования:
1. В множестве значений словаря возвращенного методом convert класса ConvertableUtil должны содержаться все элементы
конвертируемого списка.
2. Размер словаря возвращенного методом convert класса ConvertableUtil должен быть равен размеру конвертируемого списка.
3. В множестве ключей словаря возвращенного методом convert класса ConvertableUtil должны содержаться ключи
конвертируемого списка, полученные с помощью вызова метода getKey на каждом объекте списка.
4. Конвертация должна проходить в соответствии с условием задачи, ключи получаем с помощью метода getKey, а значением
служат сами объекты списка.

Попытаюсь "разжевать на пальцах" как просили ниже. Не забываем для начала обозначить метод как дженерик, без этого
пляски с бубном и пустая трата времени с <?>.
Что бы ввести в игру параметры для статического метода эти параметры надо объявить в сигнатуре метода. Представьте что
это какие то переменные, которые надо как то объявить. Вот их и объявляют в сигнатуре.

В нашем статическом методе сразу обозначим что мы будем иметь дело с двумя типами: условный <K> тип-ключи и
условный <V> тип-значений. т.о. получим
public static <K, V extends Convertable<K>> Map convert(List<V> list) {
}


Какими эти типы могут быть - мы уже обозначили в сигнатуре метода, поэтому дальше, внутри самого метода, используем эти
типы просто как переменные. Например при создании поля map будем использовать просто
Map<K, V> result = new HashMap();

без всяких уточнений вроде extends

P.S. еще ниже писали что можно через рефлексию, но не забывайте 2 вещи:
1) дженериками обязательно надо научиться пользоваться, чем мы и занимаемся на этом уровне
2) рефлексия - не дешевая вещь с точки зрения производительности
Хотя для себя лучше попробовать как можно больше способов решения.
*/
public class Solution {
    public static void main(String[] args) {
        List<ConvertableUser> users = new ArrayList<>();
        users.add(new ConvertableUser(234, "First User"));
        users.add(new ConvertableUser(235, "Second User"));
        users.add(new ConvertableUser(236, "Third User"));

        Map<Integer, ConvertableUser> newMap = ConvertableUtil.convert(users);
        System.out.println(newMap);
        //{236=ConvertableUser{id=236, name='Third User'},
        // 235=ConvertableUser{id=235, name='Second User'},
        // 234=ConvertableUser{id=234, name='First User'}}

        //////////////////////////////////////////////////////////

        List<ConvertableBook> books = new ArrayList<>();
        books.add(new ConvertableBook("First Book"));
        books.add(new ConvertableBook("Second Book"));
        books.add(new ConvertableBook("Third Book"));

        Map<String, ConvertableBook> bookMap = ConvertableUtil.convert(books);
        System.out.println(bookMap);
        //{Third Book=ConvertableBook{name='Third Book'},
        // First Book=ConvertableBook{name='First Book'},
        // Second Book=ConvertableBook{name='Second Book'}}
    }
}
