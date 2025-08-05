package com.school.modules.GradesAndClasses.Services.Impl;

import com.school.modules.GradesAndClasses.DTOs.ClassroomDTO;
import com.school.modules.GradesAndClasses.Mappers.ClassroomMapper;
import com.school.modules.GradesAndClasses.Models.Classroom;
import com.school.modules.GradesAndClasses.Models.Grade;
import com.school.modules.GradesAndClasses.Repositories.ClassroomRepository;
import com.school.modules.GradesAndClasses.Repositories.GradeRepository;
import com.school.modules.GradesAndClasses.Services.ClassroomService;
import com.school.modules.GradesAndClasses.Services.GradeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    private final ClassroomRepository classroomRepository;
    private final GradeRepository gradeRepository;


    @Autowired
    public ClassroomServiceImpl(ClassroomRepository classroomRepository, GradeRepository gradeRepository) {
        this.classroomRepository = classroomRepository;
        this.gradeRepository = gradeRepository;
    }

    @Override
    public ClassroomDTO createClassroom(ClassroomDTO dto) {
        //Ensure the grade exists
        Grade grade = gradeRepository.findById(dto.getGradeId())
                .orElseThrow(() -> new EntityNotFoundException("Grade not found"));

        Classroom classroom = ClassroomMapper.toEntity(dto);
        classroom.setGrade(grade);

        Classroom saved = classroomRepository.save(classroom);
        return ClassroomMapper.toDTO(saved);
    }

    @Override
    public ClassroomDTO getClassroomById(Long id) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Classroom not found"));
        return ClassroomMapper.toDTO(classroom);
    }

    @Override
    public List<ClassroomDTO> getAllClassrooms() {
        return classroomRepository.findAll().stream()
                .map(ClassroomMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public ClassroomDTO updateClassroom(Long id, ClassroomDTO dto) {
        Classroom classroom = classroomRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Classroom not found"));

        Grade grade = gradeRepository.findById(dto.getGradeId())
                .orElseThrow(() -> new EntityNotFoundException("Grade not found"));

        classroom.setName(dto.getName());
        classroom.setCapacity(dto.getCapacity());
        classroom.setGrade(grade);

        Classroom updated = classroomRepository.save(classroom);
        return ClassroomMapper.toDTO(updated);
    }

    @Override
    public void deleteClassroom(Long id) {
        if (!classroomRepository.existsById(id)) {
            throw new EntityNotFoundException("Classroom not found");
        }
        classroomRepository.deleteById(id);
    }

}
