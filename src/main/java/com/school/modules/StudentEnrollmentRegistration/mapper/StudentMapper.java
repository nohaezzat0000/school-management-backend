package com.school.modules.StudentEnrollmentRegistration.mapper;

import com.school.modules.StudentEnrollmentRegistration.Dto.StudentDto;
import com.school.modules.StudentEnrollmentRegistration.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDto toDto(Student student);

    Student toEntity(StudentDto dto);
}
