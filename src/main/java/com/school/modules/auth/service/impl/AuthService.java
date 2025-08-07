package com.school.modules.auth.service.impl;

import com.school.modules.auth.dto.SignUpRequestDTO;
import com.school.modules.auth.dto.UserResponseDTO;

public interface AuthService {
    UserResponseDTO signUp(SignUpRequestDTO dto);
}
