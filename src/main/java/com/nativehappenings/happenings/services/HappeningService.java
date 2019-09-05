package com.nativehappenings.happenings.services;

import com.nativehappenings.happenings.model.Happening;

import java.util.List;

public interface HappeningService extends GenericTemplatingService<Happening> {

    void deleteById(Long id);

    List<Happening> findByNameContains(String name);

    List<Happening.HappeningType> findAllHappeningTypes();
}
