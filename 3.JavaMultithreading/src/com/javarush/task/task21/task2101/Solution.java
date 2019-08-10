package com.javarush.task.task21.task2101;

import java.util.regex.Pattern;

/*
Определяем адрес сети
1. Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - реализуй метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).

Пример:
IP-адрес: 11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети: 11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети: 11000000 10101000 00000000 00000000 (192.168.0.0)

2. Реализовать метод print, который выведет в консоль данные в двоичном коде. Для IP-адреса(192.168.1.2)
должна быть выведена строка "11000000 10101000 00000001 00000010"
3. Метод main не участвует в тестировании


Требования:
1. Метод getNetAddress должен вычислять и возвращать адрес сети согласно переданным параметрам(IP-адрес и маска подсети).
2. Метод getNetAddress должен быть статическим и публичным.
3. Метод print должен быть статическим и публичным.
4. Метод print должен преобразовывать переданный ему IP адрес в двоичный код и выводить на экран(как в условии).
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        //System.out.println((byte) 192);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] addr = new byte[ip.length];
        for (int i = 0; i < addr.length; i++) {
            //addr[i] = (byte) (byteToint(ip[i]) & byteToint(mask[i])); <- так тоже работает
            addr[i] = (byte) (ip[i] & mask[i]);
        }
        return addr;
    }

    public static void print(byte[] bytes) {
        int[] bytes2 = new int[bytes.length];
        for (int i=0; i<bytes.length; i++){
       //System.out.print(Integer.toBinaryString(bytes[i])+" ");
            bytes2[i] = 255 & bytes[i]; // можно 0xFF в HEX  {чтоб из -64 получить обратно 192}
            //String s = String.format("%8s", Integer.toBinaryString(bytes2[i])).replace(' ', '0'); //добавляем ведущие нули, т.к. без этого печать начинаетс с 1.
            // "%8s" -> в строке д.б. 8 символов (реплейсом заменяем пробел на 1)
            String s = intTobin(bytes2[i]);
            if (i==bytes.length-1) System.out.println(s);
            else System.out.print(s+" ");

        }

    }

    public static String intTobin (int chislo){
        String result;
        result = String.format("%8s", Integer.toBinaryString(chislo)).replace(' ', '0');
        return result;
    }

    public static int byteToint (byte myByte){
        int result;
        result = myByte & 255;
        return result;
    }

    public static String printtostr(byte[] bytes) {
        int[] bytes2 = new int[bytes.length];
        String str = "";
        for (int i=0; i<bytes.length; i++){
            //System.out.print(Integer.toBinaryString(bytes[i])+" ");
            bytes2[i] = 255 & bytes[i]; // можно 0xFF в HEX  {чтоб из -64 получить обратно 192}
            //String s = String.format("%8s", Integer.toBinaryString(bytes2[i])).replace(' ', '0'); //добавляем ведущие нули, т.к. без этого печать начинаетс с 1.
            // "%8s" -> в строке д.б. 8 символов (реплейсом заменяем пробел на 1)
            String s = intTobin(bytes2[i]);
            if (i==bytes.length-1) str += s;
            else str+= s+" ";

        }
        return str;
    }

}
