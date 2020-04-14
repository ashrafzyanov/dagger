package com.ashrafzyanov.testdagger.service;

import com.ashrafzyanov.testdagger.dto.UserDTO;
import com.ashrafzyanov.testdagger.model.User;

import java.util.List;

public interface UserManager {

    List<UserDTO> getUsers();
    void addUser(UserDTO user);

}
