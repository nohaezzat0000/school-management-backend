package com.school.modules.GradesAndClasses.Controllers;

import com.school.modules.GradesAndClasses.DTOs.ClassroomDTO;
import com.school.modules.GradesAndClasses.Services.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/classrooms")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }
    @PostMapping
    public ClassroomDTO createClassroom(@RequestBody ClassroomDTO dto) {
        return classroomService.createClassroom(dto);
    }

    @GetMapping
    public List<ClassroomDTO> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    @GetMapping("/{id}")
    public ClassroomDTO getClassroomById(@PathVariable Long id) {
        return classroomService.getClassroomById(id);
    }

    @PostMapping("/update/{id}")
    public ClassroomDTO updateClassroom(@PathVariable Long id, @RequestBody ClassroomDTO dto) {
        return classroomService.updateClassroom(id, dto);
    }

    @PostMapping("/delete/{id}")
    public void deleteClassroom(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
    }
}

