package com.school.modules.GradesAndClasses.DTOs;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GradeDTO implements Serializable {
    private long id;
    private String nameAr;
    private String nameEn;
    private String level;
    private List<ClassroomDTO> classrooms;

}
