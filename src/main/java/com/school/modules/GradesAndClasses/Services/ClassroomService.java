package com.school.modules.GradesAndClasses.Services;

import com.school.modules.GradesAndClasses.DTOs.ClassroomDTO;

import java.util.List;

public interface ClassroomService {
    ClassroomDTO createClassroom(ClassroomDTO dto);
    ClassroomDTO getClassroomById(Long id);
    List<ClassroomDTO> getAllClassrooms();
    ClassroomDTO updateClassroom(Long id, ClassroomDTO dto);
    void deleteClassroom(Long id);
}
