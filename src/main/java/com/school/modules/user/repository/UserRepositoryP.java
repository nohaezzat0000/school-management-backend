package com.school.modules.user.repository;

import com.school.modules.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryP extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
