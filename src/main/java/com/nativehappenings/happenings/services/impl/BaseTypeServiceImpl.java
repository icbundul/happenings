package com.nativehappenings.happenings.services.impl;


import com.nativehappenings.happenings.dao.BaseTypeDAO;
import com.nativehappenings.happenings.model.BaseType;
import com.nativehappenings.happenings.services.BaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaseTypeServiceImpl implements BaseTypeService {

    @Autowired
    private BaseTypeDAO baseTypeDAO;

    @Override
    @Transactional
    public BaseType save(BaseType entity) {
        return baseTypeDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(BaseType entity) {
        baseTypeDAO.delete(entity);
    }

    @Override
    public BaseType find(Long id) {
        return baseTypeDAO.getOne(id);
    }

    @Override
    public List<BaseType> findAll() {
        return baseTypeDAO.findAll();
    }
}

