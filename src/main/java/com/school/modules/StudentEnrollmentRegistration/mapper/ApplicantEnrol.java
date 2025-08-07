package com.school.modules.StudentEnrollmentRegistration.mapper;

import com.school.modules.StudentEnrollmentRegistration.Dto.request.ApplicantRequest;
import com.school.modules.StudentEnrollmentRegistration.Dto.userDto;
import com.school.modules.StudentEnrollmentRegistration.model.Applicant;
import com.school.modules.auth.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface  ApplicantEnrol {

     User toEntity(userDto request);

}
