package com.nativehappenings.happenings.dao;

import com.nativehappenings.happenings.model.Happening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HappeningDAO extends JpaRepository<Happening, Long> {

    void deleteById(Long id);

    List<Happening> findAllByNameContains(String name);
}
