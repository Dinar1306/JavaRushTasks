package com.javarush.task.task14.task1415;

import java.util.ArrayList;
import java.util.List;

/* 
Клининговый центр
1. Реализовать метод cleanAllApartments.
Для каждого объекта из apartments:
2. Для однокомнатных квартир (Apt1Room) вызвать метод clean1Room.
т.е. если объект типа Apt1Room, то вызвать у него метод clean1Room.
3. Для двухкомнатных квартир (Apt2Room) вызвать метод clean2Rooms
т.е. если объект типа Apt2Room, то вызвать у него метод clean2Rooms.
4. Для трехкомнатных квартир (Apt3Room) вызвать метод clean3Rooms
т.е. если объект типа Apt3Room, то вызвать у него метод clean3Rooms.


Требования:
1. Метод cleanAllApartments должен принимать список аппартаметов в качестве параметра.
2. В методе cleanAllApartments для всех однокомнатных аппартаментов(Apt1Room) содержащихся в списке необходимо вызвать метод clean1Room.
3. В методе cleanAllApartments для всех двухкомнатных аппартаментов(Apt2Room) содержащихся в списке необходимо вызвать метод clean2Rooms.
4. В методе cleanAllApartments для всех трехкомнатных аппартаментов(Apt3Room) содержащихся в списке необходимо вызвать метод clean3Rooms.
5. Классы Apt1Room, Apt2Room, Apt3Room должны поддерживать(реализовывать) интерфейс Apartment.
*/

public class Solution {
    public static void main(String[] args) {
        List<Apartment> apartments = new ArrayList<Apartment>();
        apartments.add(new Apt1Room());
        apartments.add(new Apt2Room());
        apartments.add(new Apt3Room());

        cleanAllApartments(apartments);
    }

    public static void cleanAllApartments(List<Apartment> apartments) {
        //написать тут вашу реализацию пунктов 1-4
        for (Apartment apart : apartments) {
            if (apart instanceof Apt1Room) ((Apt1Room) apart).clean1Room();
            if (apart instanceof Apt2Room) ((Apt2Room) apart).clean2Rooms();
            if (apart instanceof Apt3Room) ((Apt3Room) apart).clean3Rooms();
        }
    }

    static interface Apartment {
    }

    static class Apt1Room implements Apartment {
        void clean1Room() {
            System.out.println("1 room is cleaned");
        }
    }

    static class Apt2Room implements Apartment {
        void clean2Rooms() {
            System.out.println("2 rooms are cleaned");
        }
    }

    static class Apt3Room implements Apartment {
        void clean3Rooms() {
            System.out.println("3 rooms are cleaned");
        }
    }
}
