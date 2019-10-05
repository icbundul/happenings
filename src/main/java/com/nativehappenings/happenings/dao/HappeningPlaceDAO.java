package com.nativehappenings.happenings.dao;

import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HappeningPlaceDAO extends JpaRepository<HappeningPlace, Long> {

    List<HappeningPlace> findAllByHappening(Happening happening);

    List<HappeningPlace> findAllByPlaceNameContains(String name);

}
