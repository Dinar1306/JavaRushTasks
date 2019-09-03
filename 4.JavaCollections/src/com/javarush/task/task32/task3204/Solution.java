package com.javarush.task.task32.task3204;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.ArrayList;

/* 
Генератор паролей
Реализуй логику метода getPassword, который должен возвращать ByteArrayOutputStream, в котором будут байты пароля.
Требования к паролю:
1) 8 символов.
2) только цифры и латинские буквы разного регистра.
3) обязательно должны присутствовать цифры, и буквы разного регистра.
Все сгенерированные пароли должны быть уникальные.

Пример правильного пароля:
wMh7smNu


Требования:
1. Класс Solution должен содержать метод getPassword(), который возвращает ByteArrayOutputStream со сгенерированным паролем.
2. Длина пароля должна составлять 8 символов.
3. Пароль должен содержать хотя бы одну цифру.
4. Пароль должен содержать хотя бы одну латинскую букву нижнего регистра.
5. Пароль должен содержать хотя бы одну латинскую букву верхнего регистра.
6. Пароль не должен содержать других символов, кроме цифр и латинских букв разного регистра.
7. Сгенерированные пароли должны быть уникальными.
*/
public class Solution {
    static ArrayList<ByteArrayOutputStream> baosList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

//    Вы можете сделать это следующим образом:
//
//    String lower = "abc...xyz";
//    String digits = "0123456789";
//    String punct = "!#$&...";
//    String ... // further characer classes
//            (Обратите внимание на те части ..., которые вы должны заполнить сами).
//
//    Из параметров, которые пользователь выбирает, вы создаете строку символов на выбор, объединяя соответствующие классы символов.
//
//    Наконец, вы запускаете цикл n раз, где n - количество требуемых символов. В каждом раунде вы выбираете случайный символ из созданной вами Строки и добавляете ее к результату:
//
//    StringBuilder sb = new StringBuilder();
//    int n = ....; // how many characters in password
//    String set = ....; // characters to choose from
//        for (i= 0; i < n; i++) {
//        int k = ....; // random number between 0 and set.length()-1 inklusive
//        sb.append(set.charAt(k));
//    }
//    String result = sb.toString();


    public static ByteArrayOutputStream getPassword() throws IOException {
        StringBuilder sb = new StringBuilder();
        String lower = "abcdefghijklmnopqrstuvwxyz"; boolean isLower =false;
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; boolean isUpper=false;
        String digits = "0123456789";                boolean isDigit=false;
        Random random = new Random();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(lower);
        arrayList.add(upper);
        arrayList.add(digits);
       // int randomString = new SecureRandom().nextInt(91)
        for (int i= 0; i < 8; i++) {

            String getString = arrayList.get(new Random().nextInt(3));
            //int k = 0; // random number between 0 and set.length()-1 inklusive
            sb.append(getString.charAt(new Random().nextInt(getString.length())));
        }
//проверяем что есть и upper и lower и digit
        for (int i=0; i<sb.length(); i++){
            if (lower.contains(sb.substring(i,i+1))){
                isLower = true;
            }
            if (upper.contains(sb.substring(i,i+1))){
                isUpper = true;
            }
            if (digits.contains(sb.substring(i,i+1))){
                isDigit = true;
            }
        }
        byte[] array = sb.toString().getBytes();
        ByteArrayOutputStream baos = new ByteArrayOutputStream(array.length);
        baos.write(array);

        if ((isDigit && isUpper && isLower) && !baosList.contains(baos)) {
            baosList.add(baos);
            return baos;
        } else
            return getPassword();

//        if (noLower) {sb.append(new Random().nextInt(lower.length()));sb.deleteCharAt(0);}
//        if (noUpper) {sb.append(new Random().nextInt(upper.length()));sb.deleteCharAt(0);}
//        if (noDigit) {sb.append(new Random().nextInt(digits.length()));sb.deleteCharAt(0);}

        //return baos;
    }
}