package com.javarush.task.task29.task2909.human;

public class Teacher extends UniversityPerson {

    private int numberOfStudents;


    public Teacher(String name, int age, int numberOfStudents) {
        super(name, age);

        //super(false);
        this.name = name;
        this.age = age;
        this.numberOfStudents = numberOfStudents;
    }

    public Teacher(University university) {
        super(university);
    }

    public void live() {
        teach();
    }

    public void teach() {
    }

    @Override
    public String getPosition() {
        return "Преподаватель";
    }

//    public void printData() {
//        System.out.println(String.format("%s: %s",getPosition(),name));
//    }
}