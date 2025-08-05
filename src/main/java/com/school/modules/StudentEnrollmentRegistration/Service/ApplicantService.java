package com.school.modules.StudentEnrollmentRegistration.Service;

import com.school.modules.StudentEnrollmentRegistration.Dto.ApplicantRequestDto;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;

import java.util.List;

public interface ApplicantService {
    Applicant registerApplicant(ApplicantRequestDto requestDto);

    List<Applicant> getAllApplicants();
    Applicant getApplicantById(Long id);
    Applicant acceptApplicantById(Long id);
    Applicant rejectApplicantById(Long id);

}
