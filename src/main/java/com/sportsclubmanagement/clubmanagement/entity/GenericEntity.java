package com.sportsclubmanagement.clubmanagement.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
@Data
public abstract class GenericEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(columnDefinition = "integer DEFAULT 0")
    protected Integer version;

    @Column(name = "CREATED_BY")
    @CreatedBy
    protected String createdBy;

    @Column(name = "MODIFIED_BY")
    @LastModifiedBy
    protected String modifiedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATION_DATE", nullable = false, updatable = false)
    protected Date creationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MODIFICATION_DATE")
    protected Date modificationDate;

    protected GenericEntity() {
    }

    @PrePersist
    public void onCreate() {
        this.creationDate = new Date();
    }

    @PreUpdate
    public void onUpdate() {
        this.modificationDate = new Date();
    }

}