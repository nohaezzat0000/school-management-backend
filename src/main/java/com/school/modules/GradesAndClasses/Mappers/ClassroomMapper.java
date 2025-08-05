package com.school.modules.GradesAndClasses.Mappers;

import com.school.modules.GradesAndClasses.DTOs.ClassroomDTO;
import com.school.modules.GradesAndClasses.Models.Classroom;
import com.school.modules.GradesAndClasses.Models.Grade;

public class ClassroomMapper {

    public static ClassroomDTO toDTO(Classroom classroom) {
        ClassroomDTO dto = new ClassroomDTO();
        dto.setId(classroom.getId());
        dto.setName(classroom.getName());
        dto.setCapacity(classroom.getCapacity());
        dto.setGradeId(classroom.getGrade() !=null ? classroom.getGrade().getId() : null);
        return dto;
    }

    public static Classroom toEntity(ClassroomDTO dto) {
        Classroom classroom = new Classroom();
        classroom.setName(dto.getName());
        classroom.setCapacity(dto.getCapacity());

        Grade grade = new Grade();
        grade.setId(dto.getGradeId());
        classroom.setGrade(grade);

        return classroom;
    }
}
