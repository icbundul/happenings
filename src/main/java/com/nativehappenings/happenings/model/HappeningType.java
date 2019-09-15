package com.nativehappenings.happenings.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("happeningType")
public class HappeningType extends BaseType {
    private static final long serialVersionUID = 1L;

    public HappeningType() {
    }
}
