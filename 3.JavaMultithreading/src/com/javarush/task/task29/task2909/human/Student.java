package com.javarush.task.task29.task2909.human;

import java.util.Date;

public class Student extends UniversityPerson {
    private int course;
    private double averageGrade;

    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        //super(false);
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }

    public Student(University university) {
        super(university);
    }

    public Student(String name, int age) {
        super(name, age);
    }

    public void live() {
        learn();
    }

    public void learn() {
    }
    @Override
    public String getPosition(){
        String s = "Студент";
        return s;
    }

//    public void printData() {
//        System.out.println(String.format("%s: %s",getPosition(),name));
//    }

//    public void incAverageGradeBy01() {
//        averageGrade += 0.1;
//    }
//
//    public void incAverageGradeBy02() {
//        averageGrade += 0.2;
//    }

    public void incAverageGrade(double delta){
        //averageGrade += delta;
        setAverageGrade(getAverageGrade()+delta);
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int i) {
        this.course=i;
    }

    public void setBeginningOfSession(/*int day, int month, int year*/ Date date) {
        beginningOfSession = date;/* new Date(*//*year, month, day*//*);*/
    }

    public void setEndOfSession(/*int day, int month, int year*/ Date date) {
        endOfSession = date;/* new Date(*//*year, month, day*//*);*/
    }

    /*public void setEndOfSession(int day, int month, int year) {
        endOfSession = new Date(year, month, day);
    }*/

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double d) {
        this.averageGrade = d;
    }
}