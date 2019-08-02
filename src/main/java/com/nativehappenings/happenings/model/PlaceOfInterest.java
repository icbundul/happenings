package com.nativehappenings.happenings.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// @author ivanc 09.05.2019
@Entity
@Table(name = "PlacesOfInterest")
public class PlaceOfInterest extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String name;

    private BigDecimal locationX;

    private BigDecimal locationY;

    @ManyToOne
    @JoinColumn(name="fk_happeningPlace")
    private HappeningPlace happeningPlace;

    @OneToMany(mappedBy = "placeOfInterest")
    private List<PlaceOfInterestItem> placeOfInterestItems = new ArrayList<PlaceOfInterestItem>();

    //------------------------
    // Constructors
    //------------------------

    public PlaceOfInterest() {
    }

    public PlaceOfInterest(String name, BigDecimal locationX, BigDecimal locationY, HappeningPlace happeningPlace) {
        this();
        this.name = name;
        this.locationX = locationX;
        this.locationY = locationY;
        this.happeningPlace = happeningPlace;
        this.placeOfInterestItems = placeOfInterestItems;
    }

    public PlaceOfInterest(Long id, String name, BigDecimal locationX, BigDecimal locationY, HappeningPlace happeningPlace) {
        this(name, locationX, locationY, happeningPlace);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getLocationX() {
        return locationX;
    }

    public void setLocationX(BigDecimal locationX) {
        this.locationX = locationX;
    }

    public BigDecimal getLocationY() {
        return locationY;
    }

    public void setLocationY(BigDecimal locationY) {
        this.locationY = locationY;
    }

    public HappeningPlace getHappeningPlace() {
        return happeningPlace;
    }

    public void setHappeningPlace(HappeningPlace happeningPlace) {
        this.happeningPlace = happeningPlace;
    }

    public List<PlaceOfInterestItem> getPlaceOfInterestItems() {
        return placeOfInterestItems;
    }

    public void setPlaceOfInterestItems(List<PlaceOfInterestItem> placeOfInterestItems) {
        this.placeOfInterestItems = placeOfInterestItems;
    }
}
