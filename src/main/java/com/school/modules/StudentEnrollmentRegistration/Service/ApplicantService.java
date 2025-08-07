package com.school.modules.StudentEnrollmentRegistration.Service;

import com.school.modules.StudentEnrollmentRegistration.Dto.request.ApplicantRequest;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;

import java.util.List;

public interface ApplicantService {
    Applicant registerApplicant(ApplicantRequest request);

    List<Applicant> getAllApplicants();
    Applicant getApplicantById(Long id);
    Applicant acceptApplicantById(Long id);
    Applicant rejectApplicantById(Long id);

}
