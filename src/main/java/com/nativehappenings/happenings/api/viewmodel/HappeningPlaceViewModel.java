package com.nativehappenings.happenings.api.viewmodel;

import com.fasterxml.jackson.annotation.*;
import com.nativehappenings.happenings.model.Happening;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class HappeningPlaceViewModel extends BaseEntityViewModel implements Serializable {

    @NotBlank
    private String placeName;

    private String address;

    private Long locationX;

    private Long locationY;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dateFrom;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dateTo;

    private Integer orderNumber;

    @JsonIgnoreProperties("happeningPlaces")
    private Happening happening;

    private Long happeningId;

    //------------------------
    // GETTERS AND SETTERS
    //------------------------

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getHappeningId() {
        return happeningId;
    }

    public void setHappeningId(Long happeningId) {
        this.happeningId = happeningId;
    }
}
