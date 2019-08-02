package com.nativehappenings.happenings.mapper.impl;

import com.nativehappenings.happenings.api.viewmodel.BaseEntityViewModel;
import com.nativehappenings.happenings.model.BaseEntity;

public abstract class BaseEntityMapper {

    public BaseEntityViewModel convertToBaseEntityViewModel(BaseEntity entity) {

        BaseEntityViewModel viewModel = new BaseEntityViewModel();

        viewModel.setCreatedBy(entity.getCreatedBy());
        viewModel.setCreatedDatetime(entity.getCreatedDatetime());
        viewModel.setLastUpdatedBy(entity.getLastUpdatedBy());
        viewModel.setNotes(entity.getNotes());

        return viewModel;
    }
}
