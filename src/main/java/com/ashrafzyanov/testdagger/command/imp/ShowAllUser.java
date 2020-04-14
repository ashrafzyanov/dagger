package com.ashrafzyanov.testdagger.command.imp;

import com.ashrafzyanov.testdagger.command.Command;
import com.ashrafzyanov.testdagger.dto.UserDTO;
import com.ashrafzyanov.testdagger.service.UserManager;

import javax.inject.Inject;
import java.util.List;

public class ShowAllUser implements Command {

    @Inject
    private UserManager userManager;

    @Override
    public void execute() {
        List<UserDTO> users = userManager.getUsers();
        users.forEach(this::printUser);
    }

    @Override
    public String getActive() {
        return "2";
    }

    @Override
    public String getCommandName() {
        return "Show All User";
    }

    private void printUser(UserDTO user) {
        System.out.println();
        System.out.printf("FirstName: %20s - LastName: %20s\n", user.getFirstName(), user.getLastName());
    }
}
