package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen{
    public int getCountOfEggsPerMonth(){
        return 20;
    }
    @Override
    String getDescription(){
        String yaM = super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return yaM;
    }
}
