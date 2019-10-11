package com.javarush.task.task34.task3403;

/* 
Разложение на множители с помощью рекурсии
Разложить целое число n > 1 на простые множители.
Вывести в консоль через пробел все множители в порядке возрастания.
Написать рекурсивный метод для вычисления простых множителей.
Не создавай в классе Solution дополнительные поля.

Пример:
132

Вывод на консоль:
2 2 3 11


Требования:
1. В классе Solution не должны быть созданы дополнительные поля.
2. Метод recurse должен выводить на экран все простые множители числа полученного в качестве параметра (пример в условии).
3. Метод recurse не должен быть статическим.
4. Метод recurse должен быть рекурсивным.
*/
public class Solution {
    public void recurse(int n) {
        //System.out.println(Math.sqrt(n));
        //System.out.println(Math.round(Math.sqrt(n)));
//        if (n<=2) {
//            System.out.print("2 2");
//            System.exit(0);
//        }
//        int out = (int) Math.round(Math.sqrt(n));
//        System.out.print(out+" ");
//        recurse(n-out*out);
        int m = 2;
        while (m <= n) {
            if (n % m == 0) {
                System.out.print(m + " ");
                if (m == n)
                    return;
                recurse(n/m);
                break;
            }
            m++;
        }


    }

}
