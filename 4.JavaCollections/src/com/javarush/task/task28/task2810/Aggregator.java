package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.Provider;
import com.javarush.task.task28.task2810.model.Strategy;

import java.io.IOException;
import java.util.ArrayList;

public class Aggregator {
    public static void main(String[] args) throws IOException {
        //В методе main создай провайдер, а потом создай контроллер с этим провайдером.
        Provider[] providers = {new Provider(null)};
        Controller controller = new Controller(providers);
        //В методе main вместо вывода на экран напиши controller.scan();
        controller.scan();
    }
}
