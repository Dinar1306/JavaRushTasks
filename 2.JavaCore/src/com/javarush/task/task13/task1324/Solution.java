package com.javarush.task.task13.task1324;

import java.awt.*;

/* 
Один метод в классе
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }

    public interface Animal {
        default Color getColor(){return Color.RED;}

        default Integer getAge(){return 10;}
    }

    public static class Fox implements Animal{
        public String getName() {
            return "Fox";
        }
       // public Color getColor() {return Color.RED;}   //эти два метода необходимо реализовать, если в интерфейсе они не default
       // public Integer getAge() {return 10; // сам установил возраст }
    }
}
