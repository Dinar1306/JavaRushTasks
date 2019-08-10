package com.javarush.task.task22.task2212;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Проверка номера телефона
Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.

Критерии валидности:
1) если номер начинается с '+', то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков '-', которые не могут идти подряд
4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false


Требования:
1. Метод checkTelNumber должен возвращать значение типа boolean.
2. Метод checkTelNumber должен быть публичным.
3. Метод checkTelNumber должен принимать один параметр типа String.
4. Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.
*/
public class Solution {

    /*
    // MY //
    public static boolean checkTelNumber(String telNumber) {
        boolean res, res1, res2, res3, res4, res5, res6, res7;

        res = false; // начальное значение

        //1) если номер начинается с '+', то он содержит 12 цифр
        res1 = false;
        int count = 0;

        if (telNumber.charAt(0) == '+')
        {
             Pattern part1 = Pattern.compile("\\d");
             Matcher match1 = part1.matcher(telNumber);
             while(match1.find())
                {
                   count++;
                }
            if (count == 12) res1 = true; //если чисел 12 и вначале +
        }


        //2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        res2 = false;
        count = 0;
        boolean temp1 = Character.isDigit(telNumber.charAt(0));
        boolean temp2 = false;
        Pattern p = Pattern.compile("\\(");
        Character temp_char = telNumber.charAt(0);
        Matcher m = p.matcher(temp_char.toString());
        temp2 = m.find();
        if (temp1 | temp2) {
            for (int i=0; i<telNumber.length(); i++) {
                if (Character.isDigit(telNumber.charAt(i))){
                    count++;
                }
            }
            if (count == 10) res2 = true; //если чисел 10 и вначале ( или цифра
        }

        //3) может содержать 0-2 знаков '-', которые не могут идти подряд
        res3 = false;
        p = Pattern.compile("\\d*(\\-?\\\\d+)?\\-?\\d*\\d$");
        m = p.matcher(telNumber);
        res3 = m.find();

        //4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
        //Pattern part1 = Pattern.compile("\\( & \\)");
        res4 = false;
        if (telNumber.contains("(") & telNumber.contains(")") & (telNumber.indexOf("-")>telNumber.indexOf(")"))) {
           res4 = true;
        }



        //5) скобки внутри содержат четко 3 цифры
        //  ->  \\(\\d{3}\\)
        res5 = false;
        p = Pattern.compile("\\(\\d{3}\\)");
        m = p.matcher(telNumber);
        res5 = m.find();

        //6) номер не содержит букв
        p = Pattern.compile("\\w");
        m = p.matcher(telNumber);
        res6 = m.find();

        //7) номер заканчивается на цифру
        res7 = Character.isDigit(telNumber.charAt(telNumber.length()-1));


        // ИТОГОВЫЕ СРАВНЕНИЯ
        if (!res6) res = false; // №6 если есть буквы
        else if (res1) { // если начинается с "+" и 12 цифр
            res = res3 & res4 & res5 & res7;
        }
        else if (res2) { // если начинается с цифры и их 10
            res = res3 & res4 & res5 & res7;
        }
        //res = (((res1 | res2) & res3 )| res4) | res5 & res6 & res7;
        if (telNumber==null) res = false;
        return res;

    }
    */

    public static boolean checkTelNumber(String telNumber) {
        if (telNumber==null || telNumber.isEmpty()){
            return false;
        }
        int numsQuantity = numsQuantity(telNumber);

        if (telNumber.startsWith("+") && numsQuantity!=12){
            return false;
        }
        else if ((startsWithDigit(telNumber) || telNumber.startsWith("(")) && numsQuantity!=10){
            return false;
        }
        else if (telNumber.contains("[a-z]")){
            return false;
        }
        else if (!endsWithDigit(telNumber)){
            return false;
        }
        else if (!isMinusQuantityAndOrderOk(telNumber)){
            return false;
        }

        else if (telNumber.contains("(") || telNumber.contains(")")){
            if (!hasTwoBrackets(telNumber)){
                return false;
            }
            else if (!rightBracketsOrder(telNumber)){
                return false;
            }
            else if (!bracketsLeftThanMinus(telNumber)){
                return false;
            }
        }

        return true;
    }


    public static int numsQuantity(String number){
        int quantity = 0;
        char[] chars = number.toCharArray();
        for (char ch : chars){
            if (Character.isDigit(ch)){
                quantity++;
            }
        }
        return quantity;
    }

    public static boolean hasTwoBrackets(String number){
        char[] chars = number.toCharArray();
        int rightBracketQuantity = 0;
        int leftBracketQuantity = 0;
        for (char ch : chars){
            if (ch == '('){
                leftBracketQuantity++;
            }
            else if (ch == ')'){
                rightBracketQuantity++;
            }
        }
        if (rightBracketQuantity == 1 && leftBracketQuantity == 1){
            return true;
        }
        else return false;
    }

    public static boolean rightBracketsOrder (String number){
        int numberOfFirst = number.indexOf('(');
        int numberOfSecond = number.indexOf(')');
        int first = numberOfFirst+1;
        int second = numberOfFirst+2;
        int third =numberOfFirst+3;
        char f = number.charAt(first);
        char s = number.charAt(second);
        char t = number.charAt(third);
        if ((numberOfSecond-numberOfFirst)!=4){
            return false;
        }
        else if (!Character.isDigit(f) || !Character.isDigit(s) ||
                !Character.isDigit(t)){
            return false;
        }
        else return true;
    }

    public static boolean bracketsLeftThanMinus(String number){
        if (number.contains("-")) {
            if (number.indexOf(')') < number.indexOf('-')) {
                return true;
            } else return false;
        }
        else return true;
    }
    public static boolean isMinusQuantityAndOrderOk (String number){
        Pattern p = Pattern.compile("-");
        Matcher m = p.matcher(number);
        int matches = 0;
        while (m.find()) {
            matches++;
        }
        if (matches==0){
            return true;
        }
        if(number.startsWith("-")){
            return false;
        }
        int firstMinusNumber = number.indexOf("-");
        int numberAfterFirstMinus = firstMinusNumber+1;
        char first = number.charAt(firstMinusNumber);
        char second = number.charAt(numberAfterFirstMinus);
        if (matches>2){
            return false;
        }
        else if ((matches == 2) && (first == second)){
            return false;
        }
        else return true;
    }
    public static boolean endsWithDigit (String tel){
        char endLetter = tel.charAt(tel.length()-1);
        if (Character.isDigit(endLetter)){
            return true;
        }
        else return false;
    }
    public static boolean startsWithDigit (String tel){
        char firstLetter = tel.charAt(0);
        if (Character.isDigit(firstLetter)){
            return true;
        }
        else return false;

    }

    public static void main(String[] args) {
        checkTelNumber("+38(050)1234567");


        Map<String,Boolean> phones = new LinkedHashMap<>();
        phones.put("+380501234567",true);
        phones.put("+38(050)1234567-",false);
        phones.put("+38050(123)(456)7",false);
        phones.put("++380501234567-", false);
        phones.put("(380)501234567",false);
        phones.put("+38050123--4567",false);
        phones.put("050123--4567",false);
        phones.put("0-50123-4567",true);
        phones.put("+38)050(1234567",false);
        phones.put("050���4567",false);
        phones.put("050123456=false",false);
        phones.put("+38(050)1-23-45-6-7",false);
        phones.put("050ххх4567",false);
        phones.put("050123456",false);
        phones.put("(0)501234567",false);
        phones.put("+38-(050)1234567",false);
        phones.put("+38((050)1234567",false);
        phones.put("+5(0--5)1234567",false);
        phones.put("1-23456789-0",true);
        phones.put("+38051202(345)-7",true);
        phones.put("+38051202(345)7",true);
        phones.put("(345)0512027",true);
        phones.put("+-313450531202",true);
        phones.put("+313450--531202",false);
        phones.put("38xx501A34567",false);
        phones.put("3805012345",true);
        phones.put("+38(0501234567",false);
        phones.put("+38(050)1234567",true);
        phones.put("+38(05)1234567",false);
        phones.put("(3)80501234567",false);
        phones.put("380-50123-45",true);
        phones.put("(380)501-234567",false);
        phones.put("(38-0)501234567",false);
        phones.put("380-(501)234567",false);
        phones.put("380(50-1)234567",false);
        phones.put("380(501)(23)4567",false);
        phones.put("+38050123(456)7",true);
        phones.put("+38050123(456)76",false);
        phones.put("+380501234(567)",false);
        phones.put("3-805-0123-45",false);
        phones.put("-3805-012345",false);
        phones.put("3805-012345-",false);
        phones.put("+38(05)01234567",false);
        phones.put("+38(0501)234567",false);
        phones.put("+38050123-45-67",true);
        phones.put("050123-4567",true);
        phones.put("7-4-4123689-5",false);
        phones.put("+313450--531202Э",false);
        phones.put("++380501234567", false);
        phones.put("(111)111111111",false);
        phones.put("AB",false);
        phones.put("1AB1",false);
        phones.put("aB",false);
        phones.put("12345678910",false);
        phones.put("+38",false);
        phones.put("222222-2222",true);
        phones.put("(050)34(125)6-7",false);
        for (Map.Entry<String,Boolean> entry: phones.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " | " + checkTelNumber(entry.getKey()));
        }
    }
}

// РЕШЕНИЕ //

/*

public class Solution {

    public static boolean checkTelNumber(String telNumber) {

        String temp = telNumber;
        int length = temp.replaceAll("\\D", "").length();
        if (telNumber.contains("[a-aA-Z]")) {return false;}
        if (length==12) {
            return telNumber.matches("(^\\+{1})\\d*(\\(\\d{3}\\))?\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        else if (length==10) {
            return telNumber.matches("^(\\d|\\(\\d{3}\\))\\d*(\\-?\\d+)?\\-?\\d*\\d$");
        }
        return false;
    }

    /*public static void main(String[] args)
    {
        Map<String,Boolean> phones = new LinkedHashMap<>();
        ArrayList<String> list = new ArrayList<>();
        phones.put("+380501234567",true);
        phones.put("+38(050)1234567-",false);
        phones.put("+38050(123)(456)7",false);
        phones.put("++380501234567-", false);
        phones.put("(380)501234567",false);
        phones.put("+38050123--4567",false);
        phones.put("050123--4567",false);
        phones.put("0-50123-4567",true);
        phones.put("+38)050(1234567",false);
        phones.put("050���4567",false);
        phones.put("050123456=false",false);
        phones.put("+38(050)1-23-45-6-7",false);
        phones.put("050ххх4567",false);
        phones.put("050123456",false);
        phones.put("(0)501234567",false);
        phones.put("+38-(050)1234567",false);
        phones.put("+38((050)1234567",false);
        phones.put("+5(0--5)1234567",false);
        phones.put("1-23456789-0",true);
        phones.put("+38051202(345)-7",true);
        phones.put("+38051202(345)7",true);
        phones.put("(345)0512027",true);
        phones.put("+-313450531202",true);
        phones.put("+313450--531202",false);
        phones.put("38xx501A34567",false);
        phones.put("3805012345",true);
        phones.put("+38(0501234567",false);
        phones.put("+38(050)1234567",true);
        phones.put("+38(05)1234567",false);
        phones.put("(3)80501234567",false);
        phones.put("380-50123-45",true);
        phones.put("(380)501-234567",false);
        phones.put("(38-0)501234567",false);
        phones.put("380-(501)234567",false);
        phones.put("380(50-1)234567",false);
        phones.put("380(501)(23)4567",false);
        phones.put("+38050123(456)7",true);
        phones.put("+38050123(456)76",false);
        phones.put("+380501234(567)",false);
        phones.put("3-805-0123-45",false);
        phones.put("-3805-012345",false);
        phones.put("3805-012345-",false);
        phones.put("+38(05)01234567",false);
        phones.put("+38(0501)234567",false);
        phones.put("+38050123-45-67",true);
        phones.put("050123-4567",true);
        phones.put("7-4-4123689-5",false);
        phones.put("+313450--531202Э",false);
        phones.put("++380501234567", false);
        phones.put("(111)111111111",false);
        phones.put("AB",false);
        phones.put("1AB1",false);
        phones.put("aB",false);
        phones.put("12345678910",false);
        phones.put("+38",false);
        phones.put("222222-2222",true);
        phones.put("(050)34(125)6-7",false);
        for (Map.Entry<String,Boolean> entry: phones.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " | " + checkTelNumber(entry.getKey()));
        }
    }
}
*/


