package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen {
    public int getCountOfEggsPerMonth(){
        return 33;
    }
    @Override
    String getDescription(){
        String yaB = super.getDescription() + " Моя страна - "+ Country.BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
        return yaB;
    }
}
