package com.nativehappenings.happenings.dao;

import com.nativehappenings.happenings.model.PlaceOfInterestItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaceOfInterestItemDAO extends JpaRepository<PlaceOfInterestItem, Long> {
}
