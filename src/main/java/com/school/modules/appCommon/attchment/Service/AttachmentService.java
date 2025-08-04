package com.school.modules.appCommon.attchment.Service;

import com.school.modules.appCommon.attchment.Dto.AttachmentDto;
import com.school.modules.appCommon.attchment.Dto.AttachmentDtoReq;
import com.school.modules.appCommon.attchment.Dto.GenericAppAttachmentsDto;
import com.school.modules.appCommon.attchment.Dto.ImageResponseDto;
import com.school.modules.appCommon.exceptions.TechnicalException;
import com.school.modules.auth.service.impl.AppUserDetails;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AttachmentService {
    // attachments with files
    AttachmentDto saveAttachment(MultipartFile multipartFile, String moduleName, String refId) throws TechnicalException;

    AttachmentDto saveAttachmentCacheable(MultipartFile multipartFile, String moduleName, String refId) throws TechnicalException;

    Optional<AttachmentDto> loadAttachmentInfoById(Long attachmentId) throws TechnicalException;

    void deleteAttachmentById(Long attachmentId) throws TechnicalException;

    List<AttachmentDto> loadAttachmentsByListOfIds(List<Long> attachmentsIds) throws TechnicalException;

    void deleteListOfAttachmentsByListOfIds(List<Long> attachmentsIds) throws TechnicalException;


    // files only
    Optional<MultipartFile> loadFileByPath(String filePath) throws TechnicalException;

    void deleteFileByPath(String filePath) throws TechnicalException;


    byte[] downloadAttachment(GenericAppAttachmentsDto attachmentsDto, String idAlt, AppUserDetails appUserDetails) throws TechnicalException, IOException;

    String previewAttachment(GenericAppAttachmentsDto attachmentsDto, String idAlt, AppUserDetails appUserDetails) throws TechnicalException, IOException;

    String getBasic64Image(String filePath) throws TechnicalException, IOException;

    ImageResponseDto getAttachmentsContent(List<AttachmentDtoReq> imagesPaths);

    String getAttachmentContent(String imagesPath);

    String getAttachmentPath(Long attachmentId);

    String getAttachmentsContentById(Long imageId);

    AttachmentDto saveAttachmentToAsset(MultipartFile multipartFile, String moduleName, String refId) throws TechnicalException;

    AttachmentDto saveAttachmentToAsset(Long attachmentId, String moduleName, String refId) throws TechnicalException;
    GenericAppAttachmentsDto loadAttachmentInfoByFilePath(String filePath) throws TechnicalException;

}
