package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лоза"); //1
        list.add("лира"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
       // ArrayList str = new ArrayList();
        //String s = null;
        for (int i = 0; i < list.size(); i++){
            if ((list.get(i).indexOf("р") != -1) & (list.get(i).indexOf("л") != -1)) {
            } // if
            else if (list.get(i).indexOf("р") != -1) {
                list.remove(i);
                i--;
            }
            else if (list.get(i).indexOf("л") != -1) {
                list.add(i, list.get(i));
                i++;
            }
        } // for i

        /*
        for (String s : list) {
            if ((s.indexOf("р") != -1) & (s.indexOf("л") != -1)) {
            }
            if (s.indexOf("л") != -1) str.add(s);
            else if (s.indexOf("р") != -1) str.remove(s);
        } //if "р" и "л"
        */

        // if ((i.contains("р")) & (!(i.contains("л")))) str.remove(i);
        //  if ((i.contains("л")) & (!(i.contains("р")))) str.add(i);
        //  if ((i.contains("л")) & ((i.contains("р")))) continue;
        //  if (!(i.contains("л")) & (!(i.contains("р")))) continue;


        return list;



    }
}