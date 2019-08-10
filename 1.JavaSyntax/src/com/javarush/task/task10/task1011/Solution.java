package com.javarush.task.task10.task1011;

/* 
Большая зарплата
Вывести на экран надпись "Я не хочу изучать Java, я хочу большую зарплату" 40 раз по образцу.

Образец:
Я не хочу изучать Java, я хочу большую зарплату
 не хочу изучать Java, я хочу большую зарплату
не хочу изучать Java, я хочу большую зарплату
е хочу изучать Java, я хочу большую зарплату
 хочу изучать Java, я хочу большую зарплату
хочу изучать Java, я хочу большую зарплату
...
зарплату


Требования:
1. Программа должна выводить текст на экран.
2. Программа должна выводить 40 строк.
3. В программе должен использоваться цикл for или while.
4. Выведенный текст должен соответствовать примеру из условия.
*/

public class Solution {
    public static int posPrint = 0; // позиция начала печати
    public static void main(String[] args) {
        String s = "Я не хочу изучать Java, я хочу большую зарплату";
        int dlinaS = s.length();
        
        String[] b = new String[dlinaS];
        //напишите тут ваш код
        for (int i=0; i<dlinaS; i++)
        {
            b[i] = String.valueOf(s.charAt(i)); // переводим буквы строки в массив
        }
        for (int i=0; i<40; i++)
        {
            posPrint = i; //меняем позицию начала печати
            printS(b);
        }
    }    
        public static void printS(String[] b){
        
         for (int j=posPrint; j<b.length; j++)
         {
            System.out.print(b[j]); //печатаем с j позиции
         }
         System.out.println();
        } // printS
    

}

