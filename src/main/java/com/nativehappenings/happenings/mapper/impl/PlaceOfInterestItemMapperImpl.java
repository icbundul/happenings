package com.nativehappenings.happenings.mapper.impl;

import com.nativehappenings.happenings.api.viewmodel.PlaceOfInterestItemViewModel;
import com.nativehappenings.happenings.dao.PlaceOfInterestDAO;
import com.nativehappenings.happenings.mapper.PlaceOfInterestItemMapper;
import com.nativehappenings.happenings.model.PlaceOfInterest;
import com.nativehappenings.happenings.model.PlaceOfInterestItem;
import org.springframework.stereotype.Component;

@Component
public class PlaceOfInterestItemMapperImpl implements PlaceOfInterestItemMapper {

    private PlaceOfInterestDAO placeOfInterestDAO;

    public PlaceOfInterestItemMapperImpl(PlaceOfInterestDAO placeOfInterestDAO) {
        this.placeOfInterestDAO = placeOfInterestDAO;
    }

    @Override
    public PlaceOfInterestItemViewModel convertToModel(PlaceOfInterestItem entity) {
        PlaceOfInterestItemViewModel viewModel = new PlaceOfInterestItemViewModel();
        viewModel.setName(entity.getName());
        viewModel.setPlaceOfInterest(entity.getPlaceOfInterest());

        return viewModel;
    }

    @Override
    public PlaceOfInterestItem convertToEntity(PlaceOfInterestItemViewModel viewModel) {
        PlaceOfInterest placeOfInterest = placeOfInterestDAO.findById(viewModel.getPlaceOfInterest().getId()).get();
        PlaceOfInterestItem entity = new PlaceOfInterestItem(viewModel.getName(), viewModel.getPlaceOfInterest());
        return entity;
    }
}
