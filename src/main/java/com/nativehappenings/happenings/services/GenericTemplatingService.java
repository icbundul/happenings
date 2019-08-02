package com.nativehappenings.happenings.services;

import com.nativehappenings.happenings.model.BaseEntity;

import java.util.List;

public interface GenericTemplatingService<T extends BaseEntity> {

    T save(T entity);

    void delete(T entity);

    T find(Long id);

    List<T> findAll();
}
