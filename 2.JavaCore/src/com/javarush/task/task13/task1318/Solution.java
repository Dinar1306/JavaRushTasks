package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        //add your code here
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Scanner sc = null;
        try {
            FileInputStream fis = new FileInputStream(br.readLine());
            sc = new Scanner(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine())
        {
            String x = sc.nextLine();
            System.out.println(x);
        }
        //System.out.println();
        sc.close();
        br.close();
    }
}