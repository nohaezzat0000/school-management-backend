package com.school.modules.appCommon.attchment.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttachmentDto {

    private Long id;
    private String fileName;
    private String filePath;
    private String fileMime;
    private Long fileSize;
    private byte [] fileContent;
    private String referenceKey;
}
