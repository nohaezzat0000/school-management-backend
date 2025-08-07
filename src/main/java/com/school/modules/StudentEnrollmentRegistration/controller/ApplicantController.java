package com.school.modules.StudentEnrollmentRegistration.controller;

import com.school.modules.StudentEnrollmentRegistration.Dto.request.ApplicantRequest;
import com.school.modules.StudentEnrollmentRegistration.Service.ApplicantService;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/enroll")
    public ResponseEntity<Applicant> registerApplicant( @RequestBody ApplicantRequest requestDto) {
        Applicant applicant = applicantService.registerApplicant(requestDto);
        return ResponseEntity.ok(applicant);
    }
    @GetMapping("/enrollments")
    public ResponseEntity<List<Applicant>> getApplicants() {
        return ResponseEntity.ok(applicantService.getAllApplicants());
    }

    @GetMapping("/enrollments/{id}")
    public ResponseEntity<Applicant> getApplicantById(@PathVariable Long id){
        return ResponseEntity.ok(applicantService.getApplicantById(id));
    }

    @PostMapping("/enrollments/{id}/accept")
    public ResponseEntity<Applicant> acceptApplicant(@PathVariable Long id){
        return ResponseEntity.ok(applicantService.acceptApplicantById(id));
    }

    @PostMapping("/enrollments/{id}/reject")
    public ResponseEntity<Applicant> rejectApplicant(@PathVariable Long id){
        return ResponseEntity.ok(applicantService.rejectApplicantById(id));
    }
}
