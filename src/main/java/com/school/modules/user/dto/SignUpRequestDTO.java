package com.school.modules.user.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpRequestDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
}
