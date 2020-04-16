package com.nativehappenings.happenings.listener;
import com.nativehappenings.happenings.model.BaseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class BaseEntityListener<T extends BaseEntity> {

    @PrePersist
    protected void setCreatedOn(T entity) {
        entity.setCreatedDatetime(new Date());

        if (getUserDetails() != null)
            entity.setCreatedBy(getUserDetails().getUsername());
    }

    @PreUpdate
    protected void onUpdate(T entity) {
        entity.setLastUpdatedDateTime(new Date());

        if (getUserDetails() != null)
            entity.setLastUpdatedBy(getUserDetails().getUsername());
    }

    private UserDetails getUserDetails() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDetails instanceof String)
            return null;

        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
