package com.ashrafzyanov.testdagger.command.imp;

import com.ashrafzyanov.testdagger.command.Command;
import com.ashrafzyanov.testdagger.dto.UserDTO;
import com.ashrafzyanov.testdagger.service.UserManager;

import javax.inject.Inject;
import java.util.Scanner;

public class AddUser implements Command {

    private UserManager userManager;

    @Inject
    public AddUser(UserManager userManager) {
        this.userManager = userManager;
    }

    @Override
    public void execute() {
        UserDTO userDTO = new UserDTO();
        Scanner scanner = new Scanner(System.in);
        System.out.print("FirstName: ");
        userDTO.setFirstName(scanner.next());
        System.out.print("LastName: ");
        userDTO.setLastName(scanner.next());
        userManager.addUser(userDTO);
    }

    @Override
    public String getActive() {
        return "1";
    }

    @Override
    public String getCommandName() {
        return "Add user";
    }

}
