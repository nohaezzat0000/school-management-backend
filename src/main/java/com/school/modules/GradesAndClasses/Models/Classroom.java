package com.school.modules.GradesAndClasses.Models;

import com.school.modules.appCommon.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "classrooms")
@Data
public class Classroom extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;
}
