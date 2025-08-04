package com.school.modules.appCommon.attchment.model;

import com.school.modules.appCommon.domain.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.io.Serializable;

    @Data
    @Entity
    @Table(name = "attachements")
    public class GenericAppAttachment extends BaseEntity implements Serializable {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(name = "id", nullable = false)
        private Long id;

        @Size(max = 500)
        @NotNull
        @Column(name = "file_name", nullable = false, length = 500)
        private String fileName;

        @Size(max = 500)
        @NotNull
        @Column(name = "file_path", nullable = false)
        private String filePath;

        @Size(max = 100)
        @Column(name = "file_mime", length = 100)
        private String fileMime;

        @Column(name = "file_size")
        private Long fileSize;

        @Transient
        private String referenceKey;


    }

