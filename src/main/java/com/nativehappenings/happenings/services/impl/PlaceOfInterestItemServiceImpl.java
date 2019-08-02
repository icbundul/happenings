package com.nativehappenings.happenings.services.impl;

import com.nativehappenings.happenings.dao.PlaceOfInterestItemDAO;
import com.nativehappenings.happenings.model.PlaceOfInterestItem;
import com.nativehappenings.happenings.services.PlaceOfInterestItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;;

import java.util.List;

@Service
public class PlaceOfInterestItemServiceImpl implements PlaceOfInterestItemService {

    @Autowired
    private PlaceOfInterestItemDAO placeOfInterestItemDAO;

    @Override
    public PlaceOfInterestItem save(PlaceOfInterestItem entity) {
        return placeOfInterestItemDAO.save(entity);
    }

    @Override
    public void delete(PlaceOfInterestItem entity) {
        placeOfInterestItemDAO.delete(entity);
    }

    @Override
    public PlaceOfInterestItem find(Long id) {
        return placeOfInterestItemDAO.getOne(id);
    }

    @Override
    public List<PlaceOfInterestItem> findAll() {
        return placeOfInterestItemDAO.findAll();
    }
}
