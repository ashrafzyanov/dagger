package com.ashrafzyanov.app.command.imp;

import com.ashrafzyanov.app.command.Command;
import com.ashrafzyanov.app.dto.UserDTO;
import com.ashrafzyanov.app.service.UserManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ShowAllUser implements Command {

    private final UserManager userManager;

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
