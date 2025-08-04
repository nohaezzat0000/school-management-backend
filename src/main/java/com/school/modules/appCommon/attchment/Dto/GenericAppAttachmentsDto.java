package com.school.modules.appCommon.attchment.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GenericAppAttachmentsDto {
    private Long id;
    private String fileName;
    private String filePath;
    private String fileMime;
    private Long fileSize;
    private String referenceKey;
}
