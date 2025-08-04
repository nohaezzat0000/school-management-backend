package com.school.modules.StudentEnrollmentRegistration.controller;

import com.school.modules.StudentEnrollmentRegistration.Dto.ApplicantRequestDto;
import com.school.modules.StudentEnrollmentRegistration.Service.ApplicantService;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/enroll")
    public ResponseEntity<Applicant> registerApplicant(@Valid @RequestBody ApplicantRequestDto requestDto) {
        Applicant applicant = applicantService.registerApplicant(requestDto);
        return ResponseEntity.ok(applicant);
    }
}
