package com.projectside.blogmahasiswa.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.OffsetDateTime;
import java.util.Date;

@MappedSuperclass
public class Updatable extends Createable {

    @Version
    @Column(name = "version", length = 10)
    private int version;

    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    @Column(name = "last_updated")
    private Date lastUpdated;

    public int getVersion() {
        return version;
    }
    public String getUpdatedBy() {
        return updatedBy;
    }
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
