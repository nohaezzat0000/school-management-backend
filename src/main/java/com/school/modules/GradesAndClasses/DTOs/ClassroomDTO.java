package com.school.modules.GradesAndClasses.DTOs;

import lombok.Data;

import java.io.Serializable;

@Data
public class ClassroomDTO implements Serializable {
    private long id;
    private  String name;
    private Integer capacity;
    private Long gradeId;
}
