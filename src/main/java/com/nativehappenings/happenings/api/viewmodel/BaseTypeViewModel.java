package com.nativehappenings.happenings.api.viewmodel;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class BaseTypeViewModel {

    private Long id;

    private String name;

    private String nameKey;

    private Integer orderNumber;

    //@JsonManagedReference
    private BaseTypeViewModel parent;

    public BaseTypeViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameKey() {
        return nameKey;
    }

    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public BaseTypeViewModel getParent() {
        return parent;
    }

    public void setParent(BaseTypeViewModel parent) {
        this.parent = parent;
    }
}
