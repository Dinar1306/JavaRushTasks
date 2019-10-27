package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age){
//        switch (age){
//            case 12: return new KidBoy();
//            case 19: return new TeenBoy();
//            default: return new Man();
//        }
        if (age >=0 & age <=12) {
            return new KidGirl();
        } else if (age >12 & age <=19){
            return new TeenGirl();
        } else return new Woman();

    }
}
