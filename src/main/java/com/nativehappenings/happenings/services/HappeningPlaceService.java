package com.nativehappenings.happenings.services;

import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningPlace;

import java.util.List;

public interface HappeningPlaceService extends GenericTemplatingService<HappeningPlace> {

    List<HappeningPlace> findAllByHappening(Happening happening);

    void deleteById(Long id);

    List<HappeningPlace> findAllByPlaceNameContains(String name);
}
