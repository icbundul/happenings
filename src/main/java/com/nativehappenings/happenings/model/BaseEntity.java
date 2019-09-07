package com.nativehappenings.happenings.model;

import com.nativehappenings.happenings.listener.BaseEntityListener;

import javax.persistence.*;
import java.util.Date;

// @author bandi 01.05.2019
@MappedSuperclass
@EntityListeners(BaseEntityListener.class)
public abstract class BaseEntity {

    public abstract Long getId();

    public abstract void setId(Long id);

    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdDatetime;

    @Column(updatable = false)
    private String createdBy;

    private String lastUpdatedBy;

    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date lastUpdatedDateTime;

    @Column(name = "notes", length = 4000)
    private String notes;

    //------------------------
    // GETTERS AND SETTERS
    //------------------------

    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDateTime() {
        return lastUpdatedDateTime;
    }

    public void setLastUpdatedDateTime(Date lastUpdatedDateTime) {
        this.lastUpdatedDateTime = lastUpdatedDateTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
