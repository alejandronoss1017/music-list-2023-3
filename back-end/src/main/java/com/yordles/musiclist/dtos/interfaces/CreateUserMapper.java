package com.yordles.musiclist.dtos.interfaces;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.yordles.musiclist.models.User;
import com.yordles.musiclist.dtos.CreateUserDTO;
import com.yordles.musiclist.dtos.UserDTO;

@Mapper
public interface CreateUserMapper {
    CreateUserMapper INSTANCE = Mappers.getMapper(CreateUserMapper.class);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    CreateUserDTO userToCreateUserDTO(User user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    User createUserDTOToUser(CreateUserDTO user);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "username", target = "username")
    UserDTO CreateUserDTOToUserDTO(CreateUserDTO user);

}
