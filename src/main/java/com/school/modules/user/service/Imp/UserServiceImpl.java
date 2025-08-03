package com.school.modules.user.service.Imp;

import com.school.modules.user.dto.UserProfileDto;
import com.school.modules.auth.model.User;
import com.school.modules.user.repository.UserRepositoryP;
import com.school.modules.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryP userRepository;

    public UserServiceImpl(UserRepositoryP userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserProfileDto getUserProfileById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new UserProfileDto(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getRole()
        );
    }
}
