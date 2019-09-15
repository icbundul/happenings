package com.nativehappenings.happenings.api.viewmodel;

import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningType;

import java.util.Date;

public class HappeningPlaceViewModel extends BaseEntityViewModel {

    private String placeName;

    private String adress;

    private Long locationX;

    private Long locationY;

    private Date dateFrom;

    private Date dateTo;

    private Integer orderNumber;

    private Happening happening;

    private HappeningType happeningType;

    //------------------------
    // GETTERS AND SETTERS
    //------------------------

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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public HappeningType getHappeningType() {
        return happeningType;
    }

    public void setHappeningType(HappeningType happeningType) {
        this.happeningType = happeningType;
    }
}
