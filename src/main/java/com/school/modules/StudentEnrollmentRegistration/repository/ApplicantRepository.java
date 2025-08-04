package com.school.modules.StudentEnrollmentRegistration.repository;

import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  ApplicantRepository extends JpaRepository<Applicant, Long> {
    boolean existsByNationalId(String nationalId);

}
