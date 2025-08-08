package com.school.modules.auth.service.impl;


import com.school.modules.user.dto.SignUpRequestDTO;
import com.school.modules.user.dto.UserResponseDTO;

public interface AuthService {
    UserResponseDTO signUp(SignUpRequestDTO dto);
}
