package com.school.modules.StudentEnrollmentRegistration.Service;

import com.school.modules.StudentEnrollmentRegistration.Dto.ApplicantRequestDto;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;

public interface ApplicantService {
    Applicant registerApplicant(ApplicantRequestDto requestDto);

}
