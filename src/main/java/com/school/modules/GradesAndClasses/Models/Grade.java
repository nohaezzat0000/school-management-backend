package com.school.modules.GradesAndClasses.Models;

import com.school.modules.appCommon.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name="grades")
@Data
public class Grade extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    id;

    private String nameAr;
    private String nameEn;
    private String level;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<Classroom> classrooms;
}
