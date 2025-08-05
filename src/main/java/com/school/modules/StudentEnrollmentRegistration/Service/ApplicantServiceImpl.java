package com.school.modules.StudentEnrollmentRegistration.Service;

import com.school.modules.StudentEnrollmentRegistration.Dto.ApplicantRequestDto;
import com.school.modules.StudentEnrollmentRegistration.enums.ApplicationStatus;
import com.school.modules.StudentEnrollmentRegistration.mapper.ApplicantMapper;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import com.school.modules.StudentEnrollmentRegistration.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    private final ApplicantMapper applicantMapper;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository,
                                ApplicantMapper applicantMapper) {
        this.applicantRepository = applicantRepository;
       this.applicantMapper = applicantMapper;
    }


    @Override
    public Applicant registerApplicant(ApplicantRequestDto dto) {
        if (applicantRepository.existsByNationalId(dto.getNationalId())) {
            throw new RuntimeException("Applicant with this National ID already exists.");
        }

        Applicant applicant = applicantMapper.toEntity(dto);
        return null;
    }

    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @Override
    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicant with this National ID Not Found."));
    }

    @Override
    public Applicant acceptApplicantById(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicatns not found with ID: "+ id));
        applicant.setStatus(ApplicationStatus.ACCEPTED);
        applicant.setUpdatedAt(LocalDateTime.now());
        return applicantRepository.save(applicant);    }

    @Override
    public Applicant rejectApplicantById(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicatns not found with ID: "+ id));
        applicant.setStatus(ApplicationStatus.REJECTED);
        applicant.setUpdatedAt(LocalDateTime.now());
        return applicantRepository.save(applicant);
    }
}
