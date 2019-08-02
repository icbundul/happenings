package com.nativehappenings.happenings.api.viewmodel;

import com.nativehappenings.happenings.model.PlaceOfInterest;
import javax.validation.constraints.NotNull;

public class PlaceOfInterestItemViewModel extends BaseEntityViewModel {

    private String name;

    @NotNull
    private PlaceOfInterest placeOfInterest;

    //------------------------
    // GETTERS AND SETTERS
    //------------------------
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
