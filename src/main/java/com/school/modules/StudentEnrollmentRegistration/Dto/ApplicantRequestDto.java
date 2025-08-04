package com.school.modules.StudentEnrollmentRegistration.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data

public class ApplicantRequestDto {

    @NotBlank(message = "Full name in Arabic is required")
    private String fullNameAr;

    @NotBlank(message = "Full name in English is required")
    private String fullNameEn;

    @NotBlank(message = "National ID is required")
    @Size(min = 10, max = 20, message = "National ID must be between 10 and 20 characters")
    private String nationalId;

    @Size(max = 20)
    private String passportNumber;

    @NotNull(message = "Birth date is required")
    @Size(max = 6)
    private LocalDate birthDate;

    @NotBlank(message = "Gender is required")
    private String gender;

    @NotBlank(message = "Nationality is required")
    private String nationality;

    private String religion;
    private String placeOfBirth;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "Invalid phone number")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Size(max = 255)
    private String email;

    @NotBlank(message = "Address is required")
    private String address;

    // Guardian
    @NotBlank(message = "Guardian name is required")
    private String guardianName;

    @NotBlank(message = "Guardian relation is required")
    private String guardianRelation;

    @NotBlank(message = "Guardian national ID is required")
    private String guardianNationalId;

    @NotBlank(message = "Guardian phone is required")
    private String guardianPhone;

    @NotBlank(message = "Guardian email is required")
    @Email(message = "Invalid guardian email format")
    @Size(max = 255)
    private String guardianEmail;

    // Academic
    @NotBlank(message = "Previous school is required")
    private String previousSchool;
    @NotBlank(message = "Certificate type is required")
    private String certificateType;

    @NotNull(message = "Graduation year is required")
    private Integer graduationYear;

    @NotNull(message = "Total grade is required")
    private Double totalGrade;

    @NotBlank(message = "General grade is required")
    private String generalGrade;

    @NotBlank(message = "Personal photo URL is required")
    private String personalPhotoUrl;
    @NotBlank(message = "Certificate URL is required")
    @Size(max = 500)
    private String certificateUrl;
    @NotBlank(message = "Birth certificate URL is required")
    @Size(max = 500)
    private String birthCertificateUrl;
    @NotBlank(message = "Guardian ID URL is required")
    @Size(max = 500)
    private String guardianIdUrl;
    @Size(max = 500)
    private String extraCertificatesUrl;
    @NotBlank(message = "Branch choice is required")
    private String branchChoice;
    @NotBlank(message = "Specialization choice is required")

    private String specializationChoice;

}
