package com.javarush.task.task11.task1123;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndMaximum(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Maximum is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndMaximum(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //Напишите тут ваше решение
        else {

            int temp;
            for (int i = array.length; i > 0; i--) {  // поверяем с конца
                for (int j = 0; j < i-1; j++){        // сравниваем последний с предпоследним
                    if (array[j]>array[j+1])
                    {
                        // перестановка
                        //Сравниваем элементы попарно, если они имеют неправильный порядок, то меняем местами
                        if (array[j]>array[j+1]) {
                            temp = array[j];
                            array[j] = array[j+1];
                            array[j+1] = temp;
                        }
                    }
                }
            }

            return new Pair<Integer, Integer>(array[0], array[array.length-1]);
        }


    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
