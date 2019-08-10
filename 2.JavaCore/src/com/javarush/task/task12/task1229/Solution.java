package com.javarush.task.task12.task1229;

/* 
Родитель класса CTO
*/

import javafx.scene.control.RadioButton;

public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    public static class CTO extends Clerk implements Businessman  {

    }

    public static class Clerk {
        public void workHard() {}
    }
    ///////// а еще так можно
    //  public static class Clerk implements Businessman {
    //      @Override
    //      public void workHard() {}
    //  }
    //  public static class CTO extends Clerk  {
    ///////////////////////////

}
