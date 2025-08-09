package com.school.modules.user.mapper;

import com.school.modules.user.dto.ContractDto;
import com.school.modules.user.model.Contract;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    ContractDto toDto(Contract contract);
    Contract toEntity(ContractDto contractDTO);
}