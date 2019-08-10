package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
Ввести с клавиатуры число. Определить, сколько в введенном числе четных цифр, а сколько нечетных.
Если число делится без остатка на 2 (т. е. остаток равен нулю), значит оно четное.
Увеличиваем на 1 счетчик четных цифр (статическая переменная even).
Иначе число нечетное, увеличиваем счетчик нечетных цифр (статическая переменная odd).
Вывести на экран сообщение: "Even: а Odd: b", где а - количество четных цифр, b - количество нечетных цифр.

Пример для числа 4445:
Even: 3 Odd: 1


Требования:
1. Программа должна считывать данные с клавиатуры.
2. Метод main должен посчитать сколько четных цифр во веденном числе и записать это количество в переменную even.
3. Метод main должен посчитать сколько нечетных цифр во веденном числе и записать это количество в переменную odd.
4. Программа должна выводить текст на экран.
5. Выведенный текст должен соответствовать заданию.
*/

public class Solution {

    public static int even;
    public static int odd;
    

    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        even = 0;
        odd = 0;
        String str_chislo;
        int kol_cifr, int_chislo, vrem_chislo;
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        str_chislo = r.readLine();
        int_chislo = Integer.parseInt(str_chislo);
        kol_cifr = str_chislo.length();
        //System.out.println(kol_cifr);
        
        vrem_chislo = int_chislo;
        for (int i = kol_cifr; i > 0; i--){
            if (chetNechet(vrem_chislo%10)) even++;
            else odd++;
            vrem_chislo = vrem_chislo/10;
        } // for in
        
        System.out.println("Even: "+even+" Odd: "+odd);
    }
    
    public static boolean chetNechet(int x){
        if (x%2 == 0) return true; 
        else return false;
    }
}
