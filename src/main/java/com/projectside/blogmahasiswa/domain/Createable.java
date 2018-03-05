package com.projectside.blogmahasiswa.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import java.io.Serializable;
import java.time.OffsetDateTime;

@MappedSuperclass
public abstract class Createable implements Serializable {

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "date_created")
    private OffsetDateTime dateCreated;

    @Column(name = "delete_flag")
    private boolean deleteFlag;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public OffsetDateTime getDateCreated() {
        return dateCreated;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setDateCreated(OffsetDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
