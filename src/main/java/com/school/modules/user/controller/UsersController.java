package com.school.modules.user.controller;

import com.school.modules.student.model.Student;
import com.school.modules.user.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return userService.getAllStudents();
    }

}
