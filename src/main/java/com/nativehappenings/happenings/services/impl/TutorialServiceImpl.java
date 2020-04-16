package com.nativehappenings.happenings.services.impl;

import com.nativehappenings.happenings.dao.TutorialDAO;
import com.nativehappenings.happenings.model.Tutorial;
import com.nativehappenings.happenings.services.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialServiceImpl implements TutorialService {

    @Autowired
    TutorialDAO tutorialDao;

    @Override
    public List<Tutorial> findByPublished(boolean published) {
        return tutorialDao.findByPublished(published);
    }

    @Override
    public List<Tutorial> findByTitleContaining(String title) {
        return tutorialDao.findByTitleContaining(title);
    }

    @Override
    public List<Tutorial> findAll() {
        return tutorialDao.findAll();
    }

    @Override
    public Optional<Tutorial> findById(long id) {
        return tutorialDao.findById(id);
    }

    @Override
    public Tutorial save(Tutorial tutorial) {
        return tutorialDao.save(tutorial);
    }

    @Override
    public void deleteById(long id) {
        tutorialDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        tutorialDao.deleteAll();
    }
}
