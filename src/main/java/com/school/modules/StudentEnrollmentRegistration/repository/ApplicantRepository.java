package com.school.modules.StudentEnrollmentRegistration.repository;

import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ApplicantRepository extends JpaRepository<Applicant, Long> {
    boolean existsByNationalId(String nationalId);

}
