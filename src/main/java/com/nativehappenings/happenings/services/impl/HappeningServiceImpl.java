package com.nativehappenings.happenings.services.impl;

import com.nativehappenings.happenings.dao.HappeningDAO;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.services.HappeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HappeningServiceImpl implements HappeningService {

    @Autowired
    private HappeningDAO happeningDAO;

    @Override
    @Transactional
    public Happening save(Happening entity) {
        return happeningDAO.save(entity);
    }

    @Override
    @Transactional
    public void delete(Happening entity) {
        happeningDAO.delete(entity);
    }

    @Override
    public Happening find(Long id) {
        Optional<Happening> result = happeningDAO.findById(id);
        //result.ifPresent(it -> ..) ; // do something with the value if present
        //result.map(it -> …); // map the value if present
        return result.orElse(null); // if you want to continue just like before

    }

    @Override
    public List<Happening> findAll() {
        return happeningDAO.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        happeningDAO.deleteById(id);
    }

    @Override
    public List<Happening> findByNameContains(String name) {
        return happeningDAO.findAllByNameContains(name);
    }
}
