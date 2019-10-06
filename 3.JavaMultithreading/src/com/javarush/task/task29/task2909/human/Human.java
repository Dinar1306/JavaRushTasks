package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private List<Human> children = new ArrayList<>();
    private int id;
    protected int age;
    protected String name;
    protected Size size;
    //protected int[] size;
    public class Size{
        public int height;
        public int weight;
    }

//    protected boolean isSoldier;

//    public static final int FIRST = 1;
//    public static final int SECOND = 2;
//    public static final int THIRD = 3;
//    public static final int FOURTH = 4;
    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        /*
        switch (code) {
            case 1:
                bloodGroup = BloodGroup.first();
                break;
            case 2:
                bloodGroup = BloodGroup.second();
                break;
            case 3:
                bloodGroup = BloodGroup.third();
                break;
            case 4:
                bloodGroup = BloodGroup.fourth();
                break;
        }*/
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public Human(String name, int age) {
        this.age = age;
        this.name = name;
        this.id = nextId;
        nextId++;
    }

    public Human() {
    }

    public void printData() {
        System.out.println(String.format("%s: %s",getPosition(),name));
    }

    public String getPosition(){return "Человек";}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

//    public void setChildren(List<Human> children) {
//        this.children = children;
//    }
    public void addChild(Human human){
        children.add(human);
    }

    public void removeChild(Human human){
        children.remove(human);
    }

    public void live() {
//        if (isSoldier)
//            fight();
    }

//    public void fight() {
//    }

    public int getId() {
        return id;
    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }
}