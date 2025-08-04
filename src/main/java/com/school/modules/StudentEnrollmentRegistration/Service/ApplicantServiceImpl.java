package com.school.modules.StudentEnrollmentRegistration.Service;

import com.school.modules.StudentEnrollmentRegistration.Dto.ApplicantRequestDto;
import com.school.modules.StudentEnrollmentRegistration.mapper.ApplicantMapper;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import com.school.modules.StudentEnrollmentRegistration.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ApplicantServiceImpl implements ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private ApplicantMapper applicantMapper;

    @Override
    public Applicant registerApplicant(ApplicantRequestDto dto) {
        if (applicantRepository.existsByNationalId(dto.getNationalId())) {
            throw new RuntimeException("Applicant with this National ID already exists.");
        }

        Applicant applicant = applicantMapper.toEntity(dto);
        return applicantRepository.save(applicant);
    }
}
