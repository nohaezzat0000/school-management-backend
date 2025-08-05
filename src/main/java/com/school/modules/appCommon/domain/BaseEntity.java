package com.school.modules.appCommon.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@Slf4j
public class BaseEntity implements Serializable {

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "created_by")
    @CreatedBy
    private Long createdBy;

    @Column(name = "created_in")
    @CreationTimestamp
    private LocalDateTime createdIn;


    @Column(name = "is_enabled")
    private Boolean isEnabled;

    @Size(max = 500)
    @Column(name = "comments")
    private String comment;

    @Column(name = "last_updated_by")
    @LastModifiedBy
    private Long lastUpdatedBy;


    @Column(name = "last_updated_in")
    @UpdateTimestamp
    private LocalDateTime lastUpdatedIn;



}
