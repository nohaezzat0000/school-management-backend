package com.school.modules.GradesAndClasses.Controllers;


import com.school.modules.GradesAndClasses.DTOs.GradeDTO;
import com.school.modules.GradesAndClasses.Services.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/grades")
public class GradeController {

    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public GradeDTO createGrade(@RequestBody GradeDTO dto) {
        return gradeService.createGrade(dto);
    }

    @GetMapping
    public List<GradeDTO> getAllGrades() {
        return gradeService.getAllGrades();
    }

    @GetMapping("/{id}")
    public GradeDTO getGradeById(@PathVariable Long id) {
        return gradeService.getGradeById(id);
    }

    @PostMapping("/update/{id}")
    public GradeDTO updateGrade(@PathVariable Long id, @RequestBody GradeDTO dto) {
        return gradeService.updateGrade(id, dto);
    }

    @PostMapping("/delete/{id}")
    public void deleteGrade(@PathVariable Long id) {
        gradeService.deleteGrade(id);
    }

}
