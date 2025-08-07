package com.school.modules.user.mapper;

import com.school.modules.auth.model.User;
import com.school.modules.user.dto.LoginDto;
import com.school.modules.user.dto.SignUpRequestDTO;
import com.school.modules.user.dto.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    //User toEntity(LoginDto loginDto);
    User toEntity (SignUpRequestDTO signUpRequestDTO);
    //UserDto toDto(E entity);
    UserResponseDTO toDto(User user);


}
