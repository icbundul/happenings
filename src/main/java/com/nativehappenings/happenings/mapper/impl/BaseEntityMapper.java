package com.nativehappenings.happenings.mapper.impl;

import com.nativehappenings.happenings.api.viewmodel.BaseEntityViewModel;
import com.nativehappenings.happenings.model.BaseEntity;

public abstract class BaseEntityMapper<T extends BaseEntityViewModel> {

    public BaseEntityViewModel convertToBaseEntityViewModel(BaseEntity entity, T entityViewModel) {

        BaseEntityViewModel viewModel = entityViewModel;

        viewModel.setId(entity.getId());
        viewModel.setCreatedBy(entity.getCreatedBy());
        viewModel.setCreatedDatetime(entity.getCreatedDatetime());
        viewModel.setLastUpdatedBy(entity.getLastUpdatedBy());
        viewModel.setNotes(entity.getNotes());

        return viewModel;
    }
}
