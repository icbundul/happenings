package com.nativehappenings.happenings.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "States")
public class State extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String stateName;

    private String stateNameEn;

    private String stateInitials;

    //------------------------
    // Constructor
    //------------------------

    public State() {
    }

    public State(String stateName, String stateNameEn, String stateInitials) {
        this.stateName = stateName;
        this.stateNameEn = stateNameEn;
        this.stateInitials = stateInitials;
    }

    public State(Long id, String stateName, String stateNameEn, String stateInitials) {
        this(stateName, stateNameEn, stateInitials);
        this.id = id;
    }

    //------------------------
    // GETTERS AND SETTERS
    //------------------------

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getStateNameEn() {
        return stateNameEn;
    }

    public void setStateNameEn(String stateNameEn) {
        this.stateNameEn = stateNameEn;
    }

    public String getStateInitials() {
        return stateInitials;
    }

    public void setStateInitials(String stateInitials) {
        this.stateInitials = stateInitials;
    }
}
