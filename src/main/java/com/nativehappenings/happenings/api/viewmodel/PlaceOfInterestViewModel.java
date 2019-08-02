package com.nativehappenings.happenings.api.viewmodel;

import com.nativehappenings.happenings.model.HappeningPlace;
import java.math.BigDecimal;

public class PlaceOfInterestViewModel extends BaseEntityViewModel {

    private String name;

    private BigDecimal locationX;

    private BigDecimal locationY;

    private HappeningPlace happeningPlace;

    //------------------------
    // GETTERS AND SETTERS
    //------------------------

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
}
