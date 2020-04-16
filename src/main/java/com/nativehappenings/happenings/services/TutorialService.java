package com.nativehappenings.happenings.services;

import com.nativehappenings.happenings.model.Tutorial;

import java.util.List;
import java.util.Optional;

public interface TutorialService {

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);

    List<Tutorial> findAll();

    Optional<Tutorial> findById(long id);

    Tutorial save(Tutorial tutorial);

    void deleteById(long id);

    void deleteAll();
}
