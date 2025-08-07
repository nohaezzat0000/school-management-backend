package com.school.modules.auth.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserResponseDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
}
