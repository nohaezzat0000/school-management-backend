package com.school.modules.GradesAndClasses.Mappers;

import com.school.modules.GradesAndClasses.DTOs.ClassroomDTO;
import com.school.modules.GradesAndClasses.DTOs.GradeDTO;
import com.school.modules.GradesAndClasses.Models.Grade;

import java.util.List;
import java.util.stream.Collectors;

public class GradeMapper {
    public static GradeDTO toDTO(Grade grade) {
        GradeDTO dto = new GradeDTO();
        dto.setId(grade.getId());
        dto.setNameAr(grade.getNameAr());
        dto.setLevel(grade.getLevel());

        if(grade.getClassrooms() != null) {
            List<ClassroomDTO> classroomDTOs = grade.getClassrooms().stream()
                    .map(ClassroomMapper::toDTO)
                    .collect(Collectors.toList());
            dto.setClassrooms(classroomDTOs);
        }

        return dto;
    }

    public static Grade toEntity(GradeDTO dto) {
        Grade grade = new Grade();
        //grade.setId(dto.getId());
        grade.setNameAr(dto.getNameAr());
        grade.setNameEn(dto.getNameEn());
        grade.setLevel(dto.getLevel());

        return grade;
    }
}
