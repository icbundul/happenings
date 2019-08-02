package com.nativehappenings.happenings.services;

import com.nativehappenings.happenings.model.BaseType;

import java.util.List;

public interface BaseTypeService {

    BaseType save(BaseType entity);

    void delete(BaseType entity);

    BaseType find(Long id);

    List<BaseType> findAll();
}
