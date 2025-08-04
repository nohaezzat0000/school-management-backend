package com.school.modules.StudentEnrollmentRegistration.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentCode; // مثل رقم القيد أو رمز الطالب
    private String fullNameAr;
    private String fullNameEn;

    private String nationalId;
    private String passportNumber;

    private LocalDate birthDate;
    private String gender;
    private String nationality;
    private String religion;
    private String placeOfBirth;

    private String phone;
    private String email;
    private String address;

    // Parent Info
    private String guardianName;
    private String guardianRelation;
    private String guardianPhone;

    // Academic Details
    private String entryCertificate;
    private Integer graduationYear;
    private Double entryGrade;

    private String branch;
    private String specialization;

    private LocalDate enrollmentDate;

    // Optional: foreign key to applicant (for history tracking)
    @OneToOne
    private Applicant applicant;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Getters & Setters
}
