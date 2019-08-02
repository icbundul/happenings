package com.nativehappenings.happenings.model;


import javax.persistence.*;

@Entity
@Table(name = "PlacesOfInterestItems")
public class PlaceOfInterestItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_placeOfInterest")
    private PlaceOfInterest placeOfInterest;

    //------------------------
    // Constructors
    //------------------------
    protected PlaceOfInterestItem() {

    }

    public PlaceOfInterestItem(String name, PlaceOfInterest placeOfInterest) {
        this();
        this.name = name;
        this.placeOfInterest = placeOfInterest;
    }

    public PlaceOfInterestItem(Long id, String name, PlaceOfInterest placeOfInterest) {
        this(name, placeOfInterest);
        this.id = id;
    }


    //------------------------
    // GETTERS AND SETTERS
    //------------------------
    @Override
    public Long getId() {
        return null;
    }

    @Override
    public void setId(Long id) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceOfInterest getPlaceOfInterest() {
        return placeOfInterest;
    }

    public void setPlaceOfInterest(PlaceOfInterest placeOfInterest) {
        this.placeOfInterest = placeOfInterest;
    }
}
