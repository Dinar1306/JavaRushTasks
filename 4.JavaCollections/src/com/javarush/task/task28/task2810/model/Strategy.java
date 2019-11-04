package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.List;

//будет отвечать за получение данных с сайта.
//Т.к. для каждого сайта будет выполняться одинаковый сценарий, то будет паттерн Стратегия
public interface Strategy {
    //Добавь в интерфейс метод getVacancies(String searchString), который будет возвращать список вакансий.
    List<Vacancy> getVacancies(String searchString) throws IOException;
}
