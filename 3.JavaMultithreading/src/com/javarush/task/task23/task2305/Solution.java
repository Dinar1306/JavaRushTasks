package com.javarush.task.task23.task2305;

/* 
Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.


Требования:
1. В классе Solution должен быть реализован метод getTwoSolutions.
2. Метод getTwoSolutions должен быть статическим.
3. Метод getTwoSolutions должен быть публичным.
4. Метод getTwoSolutions должен возвращать массив типа Solution заполненный согласно заданию.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        //1.создаем массив типа Solution.
        Solution[] massiv = new Solution[2];

        //2.инициализируем каждый элемент массива (new Solution).
        Solution solution1 = new Solution();
        Solution solution2 = new Solution();

        //3.инициализируем каждый элемент массива внутреннего класса (new InnerClass) через созданный экземпляры класса Solution.
        InnerClass innerClass1 = solution1.new InnerClass();
        InnerClass innerClass2 = solution2.new InnerClass();
        solution1.innerClasses[0] = innerClass1;
        solution1.innerClasses[1] = innerClass2;
        //повторяем для второго экземпляра
        solution2.innerClasses[0] = innerClass1;
        solution2.innerClasses[1] = innerClass2;

        massiv[0] = solution1;
        massiv[1] = solution2;

        return massiv;
    }

    public static void main(String[] args) {

//        System.out.println("getTwoSolutions()[0].innerClasses[0] = "+getTwoSolutions()[0].innerClasses[0]);
//        System.out.println("getTwoSolutions()[0].innerClasses[1] = "+getTwoSolutions()[0].innerClasses[1]);
//        System.out.println("getTwoSolutions()[1].innerClasses[0] = "+getTwoSolutions()[1].innerClasses[0]);
//        System.out.println("getTwoSolutions()[1].innerClasses[1] = "+getTwoSolutions()[1].innerClasses[1]);

    }
}
