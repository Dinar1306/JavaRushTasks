package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;


import java.io.IOException;


public class Aggregator {
    public static void main(String[] args) throws IOException {
//Provider[] providers = {new Provider(new HHStrategy() {}),new Provider(new MoikrugStrategy() {})};
        HtmlView htmlView = new HtmlView();
        Provider hhProvider = new Provider(new HHStrategy());
        MoikrugStrategy moikrugStrategy = new MoikrugStrategy();
        Provider mkProvider = new Provider(moikrugStrategy);
        Provider[] providers = {hhProvider, mkProvider};
        //Model model = new Model(htmlView, hhProvider);
        Model model = new Model(htmlView, providers);
        Controller controller = new Controller(model);
        htmlView.setController(controller);
        htmlView.userCitySelectEmulationMethod();
    }
}
