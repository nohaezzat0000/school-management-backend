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

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

    @Column(name = "created_by", nullable = false, updatable = false)
    @CreatedBy
    private Long createdBy;

    @Column(name = "created_in", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createdIn;


    @Column(name = "is_enabled", nullable = false)
    private Boolean isEnabled;

    @Size(max = 500)
    @Column(name = "comments")
    private String comment;

    @Column(name = "last_updated_by", nullable = false)
    @LastModifiedBy
    private Long lastUpdatedBy;


    @Column(name = "last_updated_in", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdatedIn;



}
