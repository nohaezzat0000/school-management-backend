package com.school.modules.StudentEnrollmentRegistration.model;

import com.school.modules.appCommon.attchment.model.GenericAppAttachment;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import com.school.modules.StudentEnrollmentRegistration.enums.ApplicationStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "applicants")
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "full_name_ar", nullable = false, length = 255)
    private String fullNameAr;

    @NotNull
    @Size(max = 255)
    @Column(name = "full_name_en", nullable = false, length = 255)
    private String fullNameEn;

    @NotNull
    @Size(max = 20)
    @Column(name = "national_id", nullable = false, unique = true, length = 20)
    private String nationalId;

    @Size(max = 20)
    @Column(name = "passport_number", length = 20)
    private String passportNumber;

    @NotNull
    @Past
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotNull
    @Size(max = 6)
    @Column(name = "gender", nullable = false, length = 6)
    private String gender; // MALE / FEMALE

    @NotBlank
    @Column(name = "nationality",nullable = false)
    private String nationality;

    @NotBlank
    @Column(name = "religion", nullable = false)
    private String religion;
    @NotBlank
    @Column(name = "place_of_birth",nullable = false)
    private String placeOfBirth;
    @NotNull
    @Size(max = 20)
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @NotNull
    @Email
    @Size(max = 255)
    @Column(name = "email", nullable = false, length = 255)
    private String email;
    @NotNull
    @Column(name = "address", nullable = false)
    private String address; // Full address in one field or separate parts

    // Parent Info
    @NotNull
    @Size(max = 255)
    @Column(name = "guardian_name", nullable = false, length = 255)
    private String guardianName;
    @NotNull
    @Size(max = 100)
    @Column(name = "guardian_relation", nullable = false, length = 100)
    private String guardianRelation;
    @NotNull
    @Size(max = 20)
    @Column(name = "guardian_national_id", nullable = false, length = 20)
    private String guardianNationalId;
    @NotNull
    @Size(max = 20)
    @Column(name = "guardian_phone", nullable = false, length = 20)
    private String guardianPhone;
    @NotNull
    @Email
    @Size(max = 255)
    @Column(name = "guardian_email", nullable = false, length = 255)
    private String guardianEmail;

    // Academic Background
    @NotNull
    @Size(max = 255)
    @Column(name = "previous_school", nullable = false, length = 255)
    private String previousSchool;
    @NotNull
    @Size(max = 100)
    @Column(name = "certificate_type", nullable = false, length = 100)
    private String certificateType; // e.g. Prep Certificate
    @NotNull
    @Column(name = "graduation_year", nullable = false)
    private Integer graduationYear;
    @NotNull
    @DecimalMin("0.0")
    @DecimalMax("100.0")
    @Column(name = "total_grade", nullable = false)
    private Double totalGrade;
    @NotNull
    @Size(max = 50)
    @Column(name = "general_grade", nullable = false, length = 50)
    private String generalGrade; // ممتاز / جيد جدا

    // File paths to uploaded documents (store as URL or relative path)
    @NotNull
    @Size(max = 500)
    @Column(name = "personal_photo_url", nullable = false, length = 500)
    private String personalPhotoUrl;
    @NotNull
    @Size(max = 500)
    @Column(name = "certificate_url", nullable = false, length = 500)
    private String certificateUrl;
    @NotNull
    @Size(max = 500)
    @Column(name = "birth_certificate_url", nullable = false, length = 500)
    private String birthCertificateUrl;
    @NotNull
    @Size(max = 500)
    @Column(name = "guardian_id_url", nullable = false, length = 500)
    private String guardianIdUrl;
    @Size(max = 500)
    @Column(name = "extra_certificates_url", length = 500)
    private String extraCertificatesUrl;


    @NotNull
    @Size(max = 100)
    @Column(name = "branch_choice", nullable = false, length = 100)
    private String branchChoice;
    @NotNull
    @Size(max = 100)
    @Column(name = "specialization_choice", nullable = false, length = 100)
    private String specializationChoice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 20)
    private ApplicationStatus status; // PENDING, VERIFIED, REJECTED, ACCEPTED

    @NotNull
    @Column(name = "application_date", nullable = false)
    private LocalDateTime applicationDate;


    // Optional: track who reviewed the application
    @Size(max = 255)
    @Column(name = "reviewed_by", length = 255)
    private String reviewedBy;

    // Timestamps
    @NotNull
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @NotNull
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "att_id")
    private Long commRegisterAttId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "att_id", insertable = false, updatable = false)
    private GenericAppAttachment commRegisterAtt;

}
