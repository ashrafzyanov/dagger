package com.ashrafzyanov.testdagger.service.impl;

import com.ashrafzyanov.testdagger.dao.DAO;
import com.ashrafzyanov.testdagger.dao.UserDAO;
import com.ashrafzyanov.testdagger.dto.UserDTO;
import com.ashrafzyanov.testdagger.mapper.UserMapper;
import com.ashrafzyanov.testdagger.model.User;
import com.ashrafzyanov.testdagger.service.UserManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.inject.Inject;
import java.util.List;

public class UserMangerImpl implements UserManager {

    @Getter
    @Inject
    private UserMapper userMapper;

    @Inject
    private UserDAO userDAO;

    public List<UserDTO> getUsers() {
        return userMapper.mapUserToUserDto(userDAO.findAll());
    }

    public void addUser(UserDTO userDTO) {
        User user = userMapper.mapUserDTOToUser(userDTO);
        userDAO.addNew(user);
    }

}
