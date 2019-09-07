package com.nativehappenings.happenings.dao;

import com.nativehappenings.happenings.model.HappeningType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HappeningTypeDAO extends JpaRepository<HappeningType, Long> {

    Optional<HappeningType> findById(Long id);

    List<HappeningType> findAll();
}
