package com.ashrafzyanov.app.service.impl;

import com.ashrafzyanov.app.dao.UserDAO;
import com.ashrafzyanov.app.dto.UserDTO;
import com.ashrafzyanov.app.mapper.UserMapper;
import com.ashrafzyanov.app.model.User;
import com.ashrafzyanov.app.service.UserManager;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class UserMangerImpl implements UserManager {

    private final UserMapper userMapper;
    private final UserDAO userDAO;

    public List<UserDTO> getUsers() {
        return userMapper.mapUserToUserDto(userDAO.findAll());
    }

    public void addUser(UserDTO userDTO) {
        User user = userMapper.mapUserDTOToUser(userDTO);
        userDAO.addNew(user);
    }

}
