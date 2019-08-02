package com.nativehappenings.happenings.mapper;

import com.nativehappenings.happenings.api.viewmodel.BaseEntityViewModel;
import com.nativehappenings.happenings.model.BaseEntity;

public interface GenericTemplatingMapper<M extends BaseEntityViewModel, T extends BaseEntity> {

    M convertToModel(T entity);

    T convertToEntity(M viewModel);
}
