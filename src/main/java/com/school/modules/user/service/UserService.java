package com.school.modules.user.service;

import com.school.modules.student.model.Student;
import com.school.modules.student.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final StudentRepository studentRepository;

    public UserService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
