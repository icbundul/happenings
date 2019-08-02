package com.nativehappenings.happenings.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @author ivanc 01.05.2018
@Entity
@Table(name = "HappeningPlaces")
public class HappeningPlace extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Long id;

    private String placeName;

    private String adress;

    private Long locationX;

    private Long locationY;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTo;

    @ManyToOne
    @JoinColumn(name = "fk_happening")
    private Happening happening;

    @OneToMany(mappedBy = "happeningPlace")
    private List<PlaceOfInterest> placesOfIntrests = new ArrayList<>();

    //------------------------
    // Constructors
    //------------------------
    protected HappeningPlace() {
    }

    public HappeningPlace(String placeName, String adress, Long locationX, Long locationY, Date dateFrom, Date dateTo, Happening happening) {
        this();
        this.placeName = placeName;
        this.adress = adress;
        this.locationX = locationX;
        this.locationY = locationY;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.happening = happening;
    }

    public HappeningPlace(Long id, String placeName, String adress, Long locationX, Long locationY, Date dateFrom, Date dateTo, Happening happening) {
        this(placeName, adress, locationX, locationY, dateFrom, dateTo, happening);
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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Long getLocationX() {
        return locationX;
    }

    public void setLocationX(Long locationX) {
        this.locationX = locationX;
    }

    public Long getLocationY() {
        return locationY;
    }

    public void setLocationY(Long locationY) {
        this.locationY = locationY;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public Happening getHappening() {
        return happening;
    }

    public void setHappening(Happening happening) {
        this.happening = happening;
    }
}
