package com.school.modules.GradesAndClasses.DTOs;


import lombok.Data;

import java.util.List;

@Data
public class GradeDTO {
    private long id;
    private String nameAr;
    private String nameEn;
    private String level;
    private List<ClassroomDTO> classrooms;

}
