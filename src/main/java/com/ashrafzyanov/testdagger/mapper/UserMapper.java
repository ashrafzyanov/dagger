package com.ashrafzyanov.testdagger.mapper;

import com.ashrafzyanov.testdagger.dto.UserDTO;
import com.ashrafzyanov.testdagger.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "jsr330")
public interface UserMapper {

    UserDTO mapUserToUserDTO(User user);

    User mapUserDTOToUser(UserDTO userDTO);

    List<UserDTO> mapUserToUserDto(List<User> users);

}
