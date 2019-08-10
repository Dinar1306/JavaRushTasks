package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.


Требования:
1. Программа должна считывать с клавиатуры 2 строки.
2. В случае если введенные строки невозможно преобразовать в положительные целые числа, должно возникать исключение.
3. Программа должна выводить данные на экран.
4. Программа должна выводить на экран наибольший общий делитель(НОД) чисел считанных с клавиатуры и успешно завершаться.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int intA, intB, intC;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputA = br.readLine();
        String inputB = br.readLine();
        intA = Integer.parseInt(inputA);
        intB = Integer.parseInt(inputB);
        if ((intA <= 0)||(intB <= 0)) throw new Exception();

        intC = nod(intA, intB); // intC = gcd_1(intA, intB) дает тот же результат и также не проходит валидацию
        System.out.println(intC);
    } //main

    //рекурсия для поиска НОД
    public static int gcd_1(int a, int b) {
        if (b == 0)
            return a;
        return gcd_1(b, a % b);
    } //gcd_1

    // еще один вариант
    public static int nod(int a, int b) {
        int divider = 1;
        int min;
        if(a < b) min = a;
        else min = b;
        for (int i = min; i > 0; i--) {
            if((a % i) == 0 && (b % i) == 0) {
                divider = i;
                break;
            }
        }
        return divider;
    }  // nod

} //Solution
