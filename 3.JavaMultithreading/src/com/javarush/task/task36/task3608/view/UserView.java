package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

public class UserView implements View {
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        if(modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        } else {
            System.out.println("All users:");
        }
        for(User u : modelData.getUsers()) {
            System.out.println("\t" + u);
        }
        System.out.println("===================================================");

    }
    //  этот вариант тоже не проходит  //
/*    public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        } else {
            System.out.println("All users:");
            for (User tmpusr : modelData.getUsers()) {
                System.out.println("\t"+tmpusr.toString());
            }
        }
        System.out.println("===================================================");
    }*/
    //   и этот вариант тоже не проходит  //
/*   public void refresh(ModelData modelData) {
        if (modelData.isDisplayDeletedUserList()) {
            System.out.println("All deleted users:");
        } else {
            System.out.println("All users:");
            for (User tmpusr : modelData.getUsers()) {
                System.out.println("\t"+tmpusr.toString());
            }
            System.out.println("===================================================");
        }
    }*/



    @Override
    public void setController(Controller controller) {
    this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }

    public void fireEventShowDeletedUsers() {
        controller.onShowAllDeletedUsers();
    }
}
