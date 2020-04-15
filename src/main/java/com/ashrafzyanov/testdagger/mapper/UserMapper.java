package com.ashrafzyanov.testdagger.mapper;

import com.ashrafzyanov.testdagger.dto.UserDTO;
import com.ashrafzyanov.testdagger.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO mapUserToUserDTO(User user);

    User mapUserDTOToUser(UserDTO userDTO);

    List<UserDTO> mapUserToUserDto(List<User> users);

}
