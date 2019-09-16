package com.nativehappenings.happenings.api.viewmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class HappeningTypeViewModel extends BaseTypeViewModel implements Serializable {

    public HappeningTypeViewModel() {
        super();
    }
}
