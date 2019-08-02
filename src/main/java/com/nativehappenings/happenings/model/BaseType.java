package com.nativehappenings.happenings.model;

import javax.persistence.*;

@Entity
@Table(name = "BaseTypes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("type")
public class BaseType {

    @Id
    private Long id;

    private String name;

    String nameKey;

    private Integer orderNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private BaseType parent;

    public BaseType(Long id, String nameKey) {
        this.id = id;
        this.nameKey = nameKey;
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

    public BaseType getParent() {
        return parent;
    }

    public void setParent(BaseType parent) {
        this.parent = parent;
    }
}
