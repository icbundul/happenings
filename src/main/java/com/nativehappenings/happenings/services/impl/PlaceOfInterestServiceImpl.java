package com.nativehappenings.happenings.services.impl;

import com.nativehappenings.happenings.dao.PlaceOfInterestDAO;
import com.nativehappenings.happenings.model.PlaceOfInterest;
import com.nativehappenings.happenings.services.PlaceOfInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceOfInterestServiceImpl implements PlaceOfInterestService {

    @Autowired
    private PlaceOfInterestDAO placeOfInterestDAO;

    @Override
    @Transactional
    public PlaceOfInterest save(PlaceOfInterest entity) {
        return placeOfInterestDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(PlaceOfInterest entity) {
        placeOfInterestDAO.delete(entity);
    }

    @Override
    public PlaceOfInterest find(Long id) {
        return placeOfInterestDAO.getOne(id);
    }

    @Override
    public List<PlaceOfInterest> findAll() {
        return placeOfInterestDAO.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        placeOfInterestDAO.deleteById(id);
    }
}
