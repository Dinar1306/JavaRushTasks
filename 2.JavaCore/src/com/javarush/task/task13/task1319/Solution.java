package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String filename = br.readLine();
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

        while (true) {
            String stroka = br.readLine();
            bw.write(stroka + "\r\n");
            if (stroka.equals("exit")) break;
        }
        bw.close();
        br.close();

    }
}
