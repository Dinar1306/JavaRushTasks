package com.javarush.task.task28.task2810;


import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//будет содержаться бизнес логика
public class Controller {
    private Provider[] providers;
    //В Controller добавь паблик конструктор, который будет принимать столько провайдеров, сколько в него передадут для обработки.
    //Сохрани их в приватное поле providers.
    public Controller(Provider...providers) {
        //Если провайдеры не переданы в конструктор контроллера, то брось IllegalArgumentException.
        if (providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
        this.providers = providers;
    }

    //Создай метод toString в классе Controller (Alt+Insert -> toString()) со стандартной реализацией (должен выводить поле providers).
    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    //Внутри метода пройдись по всем провайдерам и собери с них все вакансии, добавь их в список. Выведи количество вакансий в консоль.
    public void scan() throws IOException {
        List<Vacancy> totalVacList = new ArrayList<>();
        try {
            for (Provider p: providers
                 ) {
                //p.setStrategy(new HHStrategy());
                totalVacList.addAll(p.getJavaVacancies("Уфа"));
            }
            System.out.println(totalVacList.size());
        } catch (NullPointerException e){
            System.out.println("NPE");
        }
    }
}
