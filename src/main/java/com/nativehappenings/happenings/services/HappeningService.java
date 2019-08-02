package com.nativehappenings.happenings.services;

import com.nativehappenings.happenings.model.Happening;

public interface HappeningService extends GenericTemplatingService<Happening> {

    void deleteById(Long id);
}
