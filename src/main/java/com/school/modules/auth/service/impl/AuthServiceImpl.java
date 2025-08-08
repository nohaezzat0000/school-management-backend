package com.school.modules.auth.service.impl;


import com.school.modules.auth.mappers.UserMapper;
import com.school.modules.auth.model.User;
import com.school.modules.user.dto.SignUpRequestDTO;
import com.school.modules.user.dto.UserResponseDTO;
import com.school.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserResponseDTO signUp(SignUpRequestDTO dto){
        if (userRepository.findByUsername(dto.getUsername()).isPresent()) {
            throw new IllegalArgumentException("username is already taken");
        }

        User user = userMapper.toEntity(dto, passwordEncoder);
        User saved = userRepository.save(user);
        return userMapper.toDto(saved);

    }
}
