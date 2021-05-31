package com.ashrafzyanov.app.command.imp;

import com.ashrafzyanov.app.command.Command;
import com.ashrafzyanov.app.dto.UserDTO;
import com.ashrafzyanov.app.service.UserManager;
import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class AddUser implements Command {

    private final UserManager userManager;

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
