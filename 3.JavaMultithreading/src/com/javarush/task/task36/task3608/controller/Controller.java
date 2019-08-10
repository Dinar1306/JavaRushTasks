package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UserView;

public class Controller {
    private Model model;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    private EditUserView editUserView;

    public void setUsersView(UserView usersView) {
        this.usersView = usersView;
    }

    private UserView usersView;

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers(){
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }
}
