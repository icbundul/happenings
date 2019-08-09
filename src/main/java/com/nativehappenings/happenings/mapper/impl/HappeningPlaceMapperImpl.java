package com.nativehappenings.happenings.mapper.impl;

import com.nativehappenings.happenings.api.viewmodel.HappeningPlaceViewModel;
import com.nativehappenings.happenings.dao.HappeningDAO;
import com.nativehappenings.happenings.mapper.HappeningPlaceMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningPlace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HappeningPlaceMapperImpl implements HappeningPlaceMapper {

    @Autowired
    private HappeningDAO happeningDAO;

    public HappeningPlaceMapperImpl(HappeningDAO happeningDAO) {
        this.happeningDAO = happeningDAO;
    }

    @Override
    public HappeningPlaceViewModel convertToModel(HappeningPlace entity) {
        HappeningPlaceViewModel viewModel = new HappeningPlaceViewModel();
        viewModel.setAdress(entity.getAdress());
        viewModel.setPlaceName(entity.getPlaceName());
        viewModel.setLocationX(entity.getLocationX());
        viewModel.setLocationY(entity.getLocationY());
        viewModel.setDateFrom(entity.getDateFrom());
        viewModel.setDateTo(entity.getDateTo());
        viewModel.setHappening(entity.getHappening());

        return viewModel;
    }

    @Override
    public HappeningPlace convertToEntity(HappeningPlaceViewModel viewModel) {
        Happening happening = this.happeningDAO.findById(viewModel.getHappening().getId()).get();
        HappeningPlace entity = new HappeningPlace(viewModel.getPlaceName(), viewModel.getAdress(),
                viewModel.getLocationX(), viewModel.getLocationY(), viewModel.getDateFrom(), viewModel.getDateTo(), happening);

        return entity;
    }
}