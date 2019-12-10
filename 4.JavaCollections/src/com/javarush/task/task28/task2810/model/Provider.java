package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

/*
логика получения данных с сайта будет полностью сосредоточена в классах, реализующих Strategy.

Провайдер в данном случае выступает в качестве контекста, если мы говорим о паттерне Стратегия.
В провайдере должен быть метод, который будет вызывать метод стратегии для выполнения главной операции.
Этот метод будет возвращать все java вакансии с выбранного сайта (ресурса).
 */
public class Provider {
    Strategy strategy;

    //В классе Provider создай пустой метод getJavaVacancies(String searchString), который будет возвращать список вакансий
    public List<Vacancy> getJavaVacancies(String searchString) throws IOException {
        if(searchString == null) return Collections.emptyList();
        //setStrategy(strategy);
        return strategy.getVacancies(searchString);}

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }
}
