package com.javarush.task.task30.task3008.client;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ClientGuiModel {
    //Добавь в него множество(set) строк в качестве final поля allUserNames.
    //В нем будет храниться список всех участников чата. Проинициализируй его.
    private final Set<String> allUserNames = new TreeSet<>();

    //Добавь поле String newMessage, в котором будет храниться новое сообщение, которое получил клиент.
    private String newMessage;

    //Добавь геттер для allUserNames, запретив модифицировать возвращенное множество.

    public Set<String> getAllUserNames() {
        return Collections.synchronizedSet(allUserNames);
    }

    public void setNewMessage(String newMessage) {
        this.newMessage = newMessage;
    }

    public String getNewMessage() {

        return newMessage;
    }

    //Добавь метод void addUser(String newUserName), который должен добавлять имя участника во множество, хранящее всех участников.
    public void addUser(String newUserName){
        allUserNames.add(newUserName);
    }

    //Добавь метод void deleteUser(String userName), который будет удалять имя участника из множества.
    public void deleteUser(String userName){allUserNames.remove(userName);}
}
