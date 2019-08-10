package com.javarush.task.task14.task1408;

public class RussianHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 50;
    }
    @Override
    String getDescription(){
        String yaR = super.getDescription() + " Моя страна - "+ Country.RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return yaR;
    }
}
