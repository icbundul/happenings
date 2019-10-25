package com.nativehappenings.happenings.mapper.impl;

import com.nativehappenings.happenings.api.viewmodel.PlaceOfInterestViewModel;
import com.nativehappenings.happenings.dao.HappeningPlaceDAO;
import com.nativehappenings.happenings.mapper.PlaceOfInterestMapper;
import com.nativehappenings.happenings.model.HappeningPlace;
import com.nativehappenings.happenings.model.PlaceOfInterest;
import org.springframework.stereotype.Component;

@Component
public class PlaceOfInterestMapperImpl extends BaseEntityMapper implements PlaceOfInterestMapper {

    private HappeningPlaceDAO happeningPlaceDAO;

    public PlaceOfInterestMapperImpl(HappeningPlaceDAO happeningPlaceDAO) {
        this.happeningPlaceDAO = happeningPlaceDAO;
    }

    @Override
    public PlaceOfInterestViewModel convertToModel(PlaceOfInterest entity) {
        PlaceOfInterestViewModel viewModel = new PlaceOfInterestViewModel();

        viewModel = (PlaceOfInterestViewModel) convertToBaseEntityViewModel(entity, viewModel);
        viewModel.setName(entity.getName());
        viewModel.setLocationX(entity.getLocationX());
        viewModel.setLocationY(entity.getLocationY());
        viewModel.setHappeningPlace(entity.getHappeningPlace());

        return viewModel;
    }

    @Override
    public PlaceOfInterest convertToEntity(PlaceOfInterestViewModel viewModel) {
        HappeningPlace happeningPlace = happeningPlaceDAO.findById(viewModel.getHappeningPlace().getId()).get();
        PlaceOfInterest entity = new PlaceOfInterest(viewModel.getName(), viewModel.getLocationX(),
                viewModel.getLocationY(), happeningPlace);

        return entity;
    }
}
