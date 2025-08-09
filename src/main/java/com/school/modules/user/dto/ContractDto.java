package com.school.modules.user.dto;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContractDto implements Serializable {
    private Long id;
    private String status;
    private String name;
}
