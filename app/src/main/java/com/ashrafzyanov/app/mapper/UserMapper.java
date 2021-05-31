package com.ashrafzyanov.app.mapper;

import com.ashrafzyanov.app.dto.UserDTO;
import com.ashrafzyanov.app.model.User;
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
