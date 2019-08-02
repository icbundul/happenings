package com.nativehappenings.happenings.dao;

import com.nativehappenings.happenings.model.PlaceOfInterest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceOfInterestDAO extends JpaRepository<PlaceOfInterest, Long> {
}
