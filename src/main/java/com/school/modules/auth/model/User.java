package com.school.modules.auth.model;

import com.school.modules.appCommon.domain.BaseEntity;
import com.school.modules.auth.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.LocalDateTime;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "users")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;

}
