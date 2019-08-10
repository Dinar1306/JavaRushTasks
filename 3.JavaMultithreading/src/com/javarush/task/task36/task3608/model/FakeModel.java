package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        User user1 = new User("Ivan", 1, 10);
        User user2 = new User("Boris", 2, 12);
        List<User> usr = new ArrayList<User>() {};
        usr.add(user1);
        usr.add(user2);

        modelData.setUsers(usr);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }


}
