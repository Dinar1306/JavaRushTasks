package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Model {
   private View view;
   private Provider[] providers;

    public void selectCity(String city) throws IOException {
        //5. Реализуй логику метода selectCity:
        //5.1. получить вакансии с каждого провайдера,
        //5.2. обновить вью списком вакансий из п.5.1.
        List<Vacancy> vacancies = new ArrayList<>();
        for (Provider p : providers
             ) {
            vacancies.addAll(p.getJavaVacancies(city));
        }
        //void update(List<Vacancy> vacancies);
        view.update(vacancies);
    }

    public Model(View view, Provider...providers) {
        //ментор: Используй аргумент переменной длинны для Provider, т.е. Provider...providers
        if (view==null||providers==null||providers.length==0 ) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }
}
