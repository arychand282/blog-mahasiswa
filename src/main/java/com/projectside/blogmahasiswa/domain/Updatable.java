package com.projectside.blogmahasiswa.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;

@MappedSuperclass
public class Updatable extends Createable {

    @Version
    @Column(name = "version", length = 10)
    private int version;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Column(name = "last_updated")
    private OffsetDateTime lastUpdated;

    public int getVersion() {
        return version;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
