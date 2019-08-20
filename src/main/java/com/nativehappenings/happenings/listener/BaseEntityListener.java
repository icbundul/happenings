package com.nativehappenings.happenings.listener;
import com.nativehappenings.happenings.model.BaseEntity;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

public class BaseEntityListener<T extends BaseEntity> {

    @PrePersist
    protected void setCreatedOn(T entity) {

        entity.setCreatedDatetime(new Date());
        entity.setCreatedBy("icurac");
        // TODO look LoggedUser.get() spring util
    }

    @PreUpdate
    protected void onUpdate(T entity) {

        entity.setLastUpdatedDateTime(new Date());
        entity.setLastUpdatedBy("icurac");
    }
}
