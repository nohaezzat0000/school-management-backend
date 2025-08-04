package com.school.modules.appCommon.attchment.repository;

import com.school.modules.appCommon.attchment.model.GenericAppAttachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface  AppAttachmentRepo extends JpaRepository<GenericAppAttachment, Long> {

    @Query("select x from GenericAppAttachment x where x.id=:attachmentId and (x.isDeleted=false or x.isDeleted is null)")
    Optional<GenericAppAttachment> getAppAttachmentByIdAndIsDeleted(Long attachmentId );
    @Query("select x from GenericAppAttachment x where x.id in :attachmentsIds and (x.isDeleted=false or x.isDeleted is null) ")
    List<GenericAppAttachment> getAppAttachmentsByIds (List<Long> attachmentsIds);

    @Query("select x from GenericAppAttachment x where x.id = :attachmentId and (x.isDeleted=false or x.isDeleted is null) ")
    Optional<GenericAppAttachment> getAppAttachmentsById (Long attachmentId);

    @Query("select x from GenericAppAttachment x where x.filePath = :filePath and (x.isDeleted=false or x.isDeleted is null) ")
    GenericAppAttachment getAppAttachmentsByFilePath (String filePath);
}
