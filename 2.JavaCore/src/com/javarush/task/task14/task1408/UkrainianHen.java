package com.javarush.task.task14.task1408;

public class UkrainianHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 10;
    }
    @Override
    String getDescription(){
        String yaY = super.getDescription() + " Моя страна - "+ Country.UKRAINE + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return yaY;
    }
}
