package com.javarush.task.task13.task1327;

public class Person implements RepkaItem{
    private String name;
    private String namePadezh;

    public Person(String name, String namePadezh) {
        this.name = name;
        this.namePadezh = namePadezh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamePadezh() {
        return this.namePadezh;
    }

    public void setNamePadezh(String namePadezh) {
        this.namePadezh = namePadezh;
    }

    public void pull(Person person){
        /*
        String out;
        person.setNamePadezh(namePadezh);
        out = person.getName() + " за " + this.getNamePadezh();
        System.out.println(out);
        */
        System.out.println(name + " за " + person.getNamePadezh());
    }
}
