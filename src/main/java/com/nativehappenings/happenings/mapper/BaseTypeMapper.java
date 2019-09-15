package com.nativehappenings.happenings.mapper;

import com.nativehappenings.happenings.api.viewmodel.BaseTypeViewModel;
import com.nativehappenings.happenings.model.BaseType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseTypeMapper<M extends BaseTypeViewModel, E extends BaseType> {

    Class<M> reference;

    public BaseTypeMapper(Class<M> classRef) {
        reference = classRef;
    }

    public M getNewTypeViewModelReference() {
        try {
            return reference.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }

    public M convertToTypeVewModel(E typeEntity) {

        M typeViewModel = getNewTypeViewModelReference();

        typeViewModel.setId(typeEntity.getId());
        typeViewModel.setName(typeEntity.getName());
        typeViewModel.setNameKey(typeEntity.getNameKey());
        typeViewModel.setOrderNumber(typeEntity.getOrderNumber());

        if (typeEntity.getParent() != null) {
            typeViewModel.setParent(convertToTypeVewModel((E) typeEntity.getParent()));
        }

        return typeViewModel;
    }

    public List<M> convertFromTypeEntityListToTypeViewModelList(List<E> typeEntities) {

        if (typeEntities == null || typeEntities.isEmpty())
            return Collections.EMPTY_LIST;

        List <M> typeViewModels = new ArrayList<>();

        for (E typeEntity: typeEntities) {
            typeViewModels.add(convertToTypeVewModel(typeEntity));
        }

        return typeViewModels;
    }

}
