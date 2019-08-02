package com.nativehappenings.happenings.services;

import com.nativehappenings.happenings.model.PlaceOfInterest;

public interface PlaceOfInterestService extends GenericTemplatingService<PlaceOfInterest> {

    void deleteById(Long id);
}
