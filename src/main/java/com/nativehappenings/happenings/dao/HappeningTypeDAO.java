package com.nativehappenings.happenings.dao;

import com.nativehappenings.happenings.model.Happening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HappeningTypeDAO extends JpaRepository<Happening.HappeningType, Long> {

    Optional<Happening.HappeningType> findById(Long id);

    List<Happening.HappeningType> findAll();
}
