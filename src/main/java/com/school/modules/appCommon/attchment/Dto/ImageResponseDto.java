package com.school.modules.appCommon.attchment.Dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class ImageResponseDto implements Serializable {
    private List<String> imagesAsBase64List;

}
