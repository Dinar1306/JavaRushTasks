package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human ded1 = new Human("Дед1", true, 60);
        Human ded2 = new Human("Дед2", true, 62);
        Human babka1 = new Human("Бабка1", false, 55);
        Human babka2 = new Human("Бабка1", false, 58);
        Human muzh = new Human("Иван", true, 35, ded1, babka1);
        Human zhena = new Human("Маша", false, 33, ded2, babka2);
        Human son = new Human("Вася", true, 25, muzh, zhena);
        Human doch = new Human("Аня", false, 22, muzh, zhena);
        Human doch2 = new Human("Лиза", false, 18, muzh, zhena);
        //String s = ded2.name;
        //System.out.println(s);
        System.out.println(ded1);
        System.out.println(ded2);
        System.out.println(babka1);
        System.out.println(babka2);
        System.out.println(muzh);
        System.out.println(zhena);
        System.out.println(son);
        System.out.println(doch);
        System.out.println(doch2);
    }

    public static class Human {
        //напишите тут ваш код
        private String name;
        private boolean sex;
        private int age;
        private Human father;
        private Human mother;

        public Human(String name, boolean sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;
        }
        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }



        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















