package com.nativehappenings.happenings.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
@DiscriminatorValue("happeningType")
public class HappeningType extends BaseType implements Serializable {
    private static final long serialVersionUID = 1L;

    public HappeningType() {
    }
}
