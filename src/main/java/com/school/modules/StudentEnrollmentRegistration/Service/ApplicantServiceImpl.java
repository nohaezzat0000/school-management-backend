package com.school.modules.StudentEnrollmentRegistration.Service;

import com.school.modules.StudentEnrollmentRegistration.Dto.request.ApplicantRequest;
import com.school.modules.StudentEnrollmentRegistration.Dto.userDto;
import com.school.modules.StudentEnrollmentRegistration.mapper.ApplicantEnrol;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import com.school.modules.StudentEnrollmentRegistration.repository.ApplicantRepository;
import com.school.modules.auth.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    private final ApplicantEnrol applicantEnrol;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository,
                                ApplicantEnrol applicantEnrol) {
        this.applicantRepository = applicantRepository;
       this.applicantEnrol = applicantEnrol;
    }


    @Override
    @Transactional
    public Applicant registerApplicant( ApplicantRequest dto) {
        if (applicantRepository.existsByNationalId(dto.getNationalId())) {
            throw new RuntimeException("Applicant with this National ID already exists.");
        }

        userDto userDto = new userDto();
        userDto.setUsername("testuser123");
        userDto.setPassword("password123");
        userDto.setFirstName("John");
        userDto.setLastName("Doe");
        userDto.setEmail("john.doe@example.com");
        userDto.setDateOfBirth(LocalDate.of(1990, 5, 20));
        userDto.setPhoneNumber("+1234567890");
        // Map dto to Applicant entity
        User applicant = applicantEnrol.toEntity(userDto);

        // Save and return the new applicant
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
        //applicant.setStatus(ApplicationStatus.ACCEPTED);
       // applicant.setUpdatedAt(LocalDateTime.now());
        return applicantRepository.save(applicant);
    }

    @Override
    public Applicant rejectApplicantById(Long id) {
        Applicant applicant = applicantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Applicatns not found with ID: "+ id));
        //applicant.setStatus(ApplicationStatus.REJECTED);
        //applicant.setUpdatedAt(LocalDateTime.now());
        return applicantRepository.save(applicant);
    }
}
