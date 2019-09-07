package com.nativehappenings.happenings.services;

import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningType;

import java.util.List;

public interface HappeningService extends GenericTemplatingService<Happening> {

    void deleteById(Long id);

    List<Happening> findByNameContains(String name);

    List<HappeningType> findAllHappeningTypes();

    HappeningType findHappeningTypeById(Long id);
}
