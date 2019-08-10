package com.javarush.task.task12.task1215;

/* 
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat {
        Pet p;
        public String getName() {return "Мурзик";}
        public Pet getChild() {return p;}
    }

    public static class Dog {
        Pet p;
        public String getName() {return "Шарик";}
        public Pet getChild() {return p;}
    }

}
