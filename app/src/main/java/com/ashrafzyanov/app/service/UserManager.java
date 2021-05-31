package com.ashrafzyanov.app.service;

import com.ashrafzyanov.app.dto.UserDTO;

import java.util.List;

public interface UserManager {

    List<UserDTO> getUsers();
    void addUser(UserDTO user);

}
