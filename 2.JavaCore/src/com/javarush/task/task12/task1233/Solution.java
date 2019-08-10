package com.javarush.task.task12.task1233;

/* 
Изоморфы наступают
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};
       // int[] data = new int[]{-1, 5, -3, -5, -2, -9, 0, -76, -5, -5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("Minimum is " + result.x);
        System.out.println("Index of minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        //напишите тут ваш код
        /*
        int min = 0;
        int index = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i] < min) {
                min = array[i];
                index = i;
            }
        }

        return new Pair<Integer, Integer>(min, index);*/
        ////////////////////////////////////

        int min = array[0], x = 0;
        for (int i = 1; i < array.length; i++)        {
            if (array[i] < min){
                min = array[i]; // сохраняем минимльное число массива
                x = i;}} // переменнй х присваиваем индекс мин числа
        return new Pair<Integer, Integer>(min, x);

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
