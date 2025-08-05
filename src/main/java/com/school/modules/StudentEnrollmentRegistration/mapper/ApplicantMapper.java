package com.school.modules.StudentEnrollmentRegistration.mapper;
import com.school.modules.StudentEnrollmentRegistration.Dto.ApplicantRequestDto;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface  ApplicantMapper {

    Applicant toEntity(ApplicantRequestDto dto);

}
