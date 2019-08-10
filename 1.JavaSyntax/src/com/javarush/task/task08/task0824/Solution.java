package com.javarush.task.task08.task0824;

/* 
Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.


Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки,
отец, мать, трое детей и выводить все объекты Human на экран.
*/
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ArrayList<Human> deti = new ArrayList<Human>();
        ArrayList<Human> parents1 = new ArrayList<Human>();
        ArrayList<Human> parents2 = new ArrayList<Human>();
        ArrayList<Human> grands = new ArrayList<Human>();
        Human child1 = new Human("сынИван", true, 15){};
        Human child2 = new Human("сынПетя", true, 11){};
        Human child3 = new Human("дочьМаша", false, 7){};
        deti.add(child1);
        deti.add(child2);
        deti.add(child3);
        Human mother = new Human("мамаОля", false, 24, deti);
        Human father = new Human("папаВася", true, 26, deti);
        parents1.add(mother);
        parents2.add(father);
        Human ded1 = new Human("дед1", true, 66, parents1);
        Human baba1 = new Human("баба1", false, 64, parents1);
        Human ded2 = new Human("дед2", true, 78, parents2);
        Human baba2 = new Human("баба2", false, 77, parents2);
        //System.out.println(deti);
        // выводим на экран
        System.out.println(ded1.toString());
        System.out.println(baba1.toString());
        System.out.println(ded2.toString());
        System.out.println(baba2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human {
        //напишите тут ваш код
        public String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        private Human (String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<Human>();
        }

        private Human (String name, boolean sex, int age, ArrayList<Human> children){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
