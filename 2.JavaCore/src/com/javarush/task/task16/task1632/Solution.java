package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. Нить 1 должна бесконечно выполняться;
1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. Нить 3 должна каждые полсекунды выводить "Ура";
1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. Нить 5 должна читать с консоли числа пока не введено слово "N", а потом вывести в консоль сумму введенных чисел.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.

Подсказка:
Нить 4 можно проверить методом isAlive()

*/

public class Solution extends Thread{
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread_1());
        threads.add(new Thread_2());
        threads.add(new Thread_3());
        threads.add(new Thread_4());
        threads.add(new Thread_5());
    }
    public static void main(String[] args) {

        threads.get(0).start();
        threads.get(1).start();
        threads.get(2).start();
        threads.get(3).start();
        threads.get(4).start();

    }

    public static class Thread_1 extends Thread {
        @Override
        public void run() {

                while (true) {

                }

        }
    }

    public static class Thread_2 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {

                    sleep(500);
                }
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread_3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Ура");
                    sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Thread_4 extends Thread implements Message{
        private boolean isCancel = false;
        @Override
        public void showWarning() {
            this.isCancel = true;
        }

        @Override
        public void run() {
            while (!isCancel){}
        }
    }

    public static class Thread_5 extends Thread {
        @Override
        public void run() {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Integer sum = 0;
            String key = null;
            ArrayList<Integer> KeyList = new ArrayList<>();

            //тут цикл по чтению ключей, пункт 1
            try {
                while (key == null){
                    key = reader.readLine();
                    if (key.equals("N")) {
                        for (Integer i : KeyList) {
                            sum = sum + i;
                        }
                        System.out.println(sum);
                        break;
                    }
                    else {
                        KeyList.add(Integer.parseInt(key));
                        key = null;
                        //System.out.println(KeyList);
                    }
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}