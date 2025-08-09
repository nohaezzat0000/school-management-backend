package com.school.modules.user.service;

import com.school.modules.user.dto.ContractDto;
import com.school.modules.user.mapper.ContractMapper;
import com.school.modules.user.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    private final ContractMapper contractMapper;

    @Autowired
    public ContractService(ContractMapper contractMapper) {
        this.contractMapper = contractMapper;
    }

    public ContractDto convertToDto(Contract contract) {
        return contractMapper.toDto(contract);
    }

    public Contract convertToEntity(ContractDto dto) {
        return contractMapper.toEntity(dto);
    }
}
