package com.school.modules.GradesAndClasses.Services;

import com.school.modules.GradesAndClasses.DTOs.GradeDTO;

import java.util.List;

public interface GradeService {
    GradeDTO createGrade(GradeDTO dto);
    GradeDTO getGradeById(Long id);
    List<GradeDTO> getAllGrades();
    GradeDTO updateGrade(Long id, GradeDTO dto);
    void deleteGrade(Long id);
}
