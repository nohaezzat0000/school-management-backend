package com.school.modules.GradesAndClasses.DTOs;

import lombok.Data;

@Data
public class ClassroomDTO {
    private long id;
    private  String name;
    private Integer capacity;
    private Long gradeId;
}
