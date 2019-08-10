package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private List<Horse> horses;

    public List<Horse> getHorses(){
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static Hippodrome game;

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        } //for i
    } // run
    public void move(){
        for (Horse kon: horses) {
            kon.move();
        }
    }
    public void print() {
        for (Horse kon: horses) {
            kon.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner() {
        Horse winner = horses.get(0);
        /*for (Horse kon: horses) {
            kon.print();
        }*/
        if (winner.distance < horses.get(1).distance){
            winner = horses.get(1);
        }
        if (winner.distance < horses.get(2).distance){
            winner = horses.get(2);
        }
        return winner;
    }
    public void printWinner(){
        System.out.println("Winner is " + getWinner().name + "!");
    }

    public static void main(String[] args) throws InterruptedException {

        Horse kon1 = new Horse("kon1",3,0);
        Horse kon2 = new Horse("kon2",3,0);
        Horse kon3 = new Horse("kon3",3,0);

        List<Horse> horses = new ArrayList<>();

        horses.add(kon1);
        horses.add(kon2);
        horses.add(kon3);

        game = new Hippodrome(horses);

        game.run();

        game.printWinner();
    }



}
