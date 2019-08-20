package com.nativehappenings.happenings.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Countries")
public class Country extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String countryName;

    private String countryISO2;

    private String countryISO3;

    private String countryNameEn;

    //------------------------
    // Constructor
    //------------------------

    public Country() {
    }

    public Country(String countryName, String countryISO2, String countryISO3, String countryNameEn) {

        this();
        this.countryName = countryName;
        this.countryISO2 = countryISO2;
        this.countryISO3 = countryISO3;
        this.countryNameEn = countryNameEn;
    }

    public Country(Long id, String countryName, String countryISO2, String countryISO3, String countryNameEn) {

        this(countryName, countryISO2, countryISO3, countryNameEn);
        this.id = id;
    }

    //------------------------
    // GETTERS AND SETTERS
    //------------------------
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryISO2() {
        return countryISO2;
    }

    public void setCountryISO2(String countryISO2) {
        this.countryISO2 = countryISO2;
    }

    public String getCountryISO3() {
        return countryISO3;
    }

    public void setCountryISO3(String countryISO3) {
        this.countryISO3 = countryISO3;
    }

    public String getCountryNameEn() {
        return countryNameEn;
    }

    public void setCountryNameEn(String countryNameEn) {
        this.countryNameEn = countryNameEn;
    }
}
