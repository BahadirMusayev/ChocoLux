package com.example.chocolux.mapper;

import com.example.chocolux.dao.entity.UserEntity;
import com.example.chocolux.model.UserDtoInput;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "fullName", source = "fullName")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "message", source = "message")
    UserEntity mapUserDtoInputToEntity(UserDtoInput userDtoInput);
}
