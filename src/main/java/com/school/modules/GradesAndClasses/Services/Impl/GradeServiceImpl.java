package com.school.modules.GradesAndClasses.Services.Impl;

import com.school.modules.GradesAndClasses.DTOs.GradeDTO;
import com.school.modules.GradesAndClasses.Mappers.GradeMapper;
import com.school.modules.GradesAndClasses.Models.Grade;
import com.school.modules.GradesAndClasses.Repositories.GradeRepository;
import com.school.modules.GradesAndClasses.Services.GradeService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GradeServiceImpl implements GradeService {
    private GradeRepository gradeRepository;

    @Autowired
    public GradeServiceImpl(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public GradeDTO createGrade(GradeDTO dto) {
        Grade grade = GradeMapper.toEntity(dto);
        Grade saved = gradeRepository.save(grade);
        return GradeMapper.toDTO(saved);
    }

    @Override
    public GradeDTO getGradeById(Long id){
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Grade not found"));

        return GradeMapper.toDTO(grade);
    }

    @Override
    public List<GradeDTO> getAllGrades() {
        return gradeRepository.findAll().stream()
                .map(GradeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GradeDTO updateGrade(Long id, GradeDTO dto) {
        Grade grade = gradeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Grade not found"));

        //Update fields
        grade.setNameAr(dto.getNameAr());
        grade.setNameEn(dto.getNameEn());
        grade.setLevel(dto.getLevel());

        Grade updated = gradeRepository.save(grade);
        return GradeMapper.toDTO(updated);
    }

    @Override
    public void deleteGrade(Long id) {
        if (!gradeRepository.existsById(id)) {
            throw new EntityNotFoundException("Grade not found");
        }
        gradeRepository.deleteById(id);
    }
}
