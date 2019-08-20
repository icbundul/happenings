package com.nativehappenings.happenings.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Places")
public class Place extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String placeName;

    private String placeNameEn;

    private String postalNumber;

    @ManyToOne
    @JoinColumn(name="fk_country")
    private Country country;

    @ManyToOne
    @JoinColumn(name="fk_state")
    private State state;

    //------------------------
    // Constructor
    //------------------------

    public Place() {

    }

    public Place(String placeName, String placeNameEn, String postalNumber, Country country, State state) {
        this.placeName = placeName;
        this.placeNameEn = placeNameEn;
        this.postalNumber = postalNumber;
        this.country = country;
        this.state = state;
    }

    public Place(Long id, String placeName, String placeNameEn, String postalNumber, Country country, State state) {
        this(placeName, placeNameEn, postalNumber, country, state);
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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceNameEn() {
        return placeNameEn;
    }

    public void setPlaceNameEn(String placeNameEn) {
        this.placeNameEn = placeNameEn;
    }

    public String getPostalNumber() {
        return postalNumber;
    }

    public void setPostalNumber(String postalNumber) {
        this.postalNumber = postalNumber;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
