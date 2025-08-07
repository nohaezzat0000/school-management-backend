package com.school.modules.StudentEnrollmentRegistration.Dto;


import lombok.Data;

import java.time.LocalDate;
@Data
public class userDto {

    private Long id;

    private String username;
    private String password;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
}
