package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.


Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private int rost;
        private int ves;
        private int age;
        private boolean sex;
        private boolean marry;
        private int childCount;

        /**
         *
         */
        public Human(){
            rost = 160;
            ves = 55;
        }
        public Human(int a, boolean b){
            age = a;
            sex = b;
        }
        public Human(boolean c, int d){
            marry = c;
            childCount = d;
        }
        public Human(int e, int f){
            rost = e;
            age = f;
        }
        public Human(boolean g, boolean h){
            sex = g;
            marry = h;
        }
        public Human(boolean i, int k, boolean j){
            sex = i;
            childCount = k;
            marry = j;
        }
        public Human(int e, int f, int l){
            rost = e;
            age = f;
            ves = l;
        }
        public Human(boolean g, boolean h, int a, int b){
            sex = g;
            marry = h;
            age = a;
            childCount = b;
        }
        public Human(int a, int b, boolean g, boolean h){
            sex = g;
            marry = h;
            age = a;
            childCount = b;
        }
        public Human(boolean b){
            sex = b;
        }
    }
}
