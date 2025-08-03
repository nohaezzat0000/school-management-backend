package com.school.modules.user.service;

import com.school.modules.user.dto.UserProfileDto;

public interface  UserService {
    UserProfileDto getUserProfileById(Long id);
}
