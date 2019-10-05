package com.nativehappenings.happenings.services.impl;

import com.nativehappenings.happenings.dao.HappeningPlaceDAO;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningPlace;
import com.nativehappenings.happenings.services.HappeningPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HappeningPlaceServiceImpl implements HappeningPlaceService {

    @Autowired
    private HappeningPlaceDAO happeningPlaceDAO;

    @Override
    @Transactional
    public HappeningPlace save(HappeningPlace entity) {
        return happeningPlaceDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(HappeningPlace entity) {
        happeningPlaceDAO.delete(entity);
    }

    @Override
    public HappeningPlace find(Long id) {
        return happeningPlaceDAO.getOne(id);
    }

    @Override
    public List<HappeningPlace> findAll() {
        return happeningPlaceDAO.findAll();
    }

    @Override
    public List<HappeningPlace> findAllByHappening(Happening happening) {
        return happeningPlaceDAO.findAllByHappening(happening);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        happeningPlaceDAO.deleteById(id);
    }

    @Override
    public List<HappeningPlace> findAllByPlaceNameContains(String name) {
        return happeningPlaceDAO.findAllByPlaceNameContains(name);
    }
}
