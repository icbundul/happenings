package com.nativehappenings.happenings.api;

import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.exceptions.HappeningValidationException;
import com.nativehappenings.happenings.mapper.HappeningMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.services.HappeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/happenings")
@CrossOrigin
public class HappeningController {

    @Autowired
    private HappeningService happeningService;

    @Autowired
    private HappeningMapper happeningMapper;

    public HappeningController() {
    }

    @GetMapping("/all")
    public List<Happening> all() {
        List<Happening> allHappenings = happeningService.findAll();
        return allHappenings;
    }

    @GetMapping("/{id}")
    public HappeningViewModel byId(@PathVariable Long id) {

        Happening happening = happeningService.find(id);

        if (happening == null) {
            throw new EntityNotFoundException();
        }

        HappeningViewModel happeningViewModel = this.happeningMapper.convertToModel(happening);

        return happeningViewModel;

    }

    @PostMapping("/")
    public Happening savePost(@RequestBody HappeningViewModel happeningViewModel, BindingResult bindingResult) {

        Happening happeningEntity = save (happeningViewModel, bindingResult);
        return happeningEntity;
    }

    @PutMapping("/")
    public Happening savePut(@RequestBody HappeningViewModel happeningViewModel, BindingResult bindingResult) {

        Happening happeningEntity = save (happeningViewModel, bindingResult);
        return happeningEntity;
    }

    @Transactional
    public Happening save(@RequestBody HappeningViewModel happeningViewModel, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new HappeningValidationException();
        }

        Happening happeningEntity = this.happeningMapper.convertToEntity(happeningViewModel);

        // save entity to database
        this.happeningService.save(happeningEntity);

        return happeningEntity;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        this.happeningService.deleteById(id);
    }

    //-------------------
    // getter and setter
    //-------------------

    public HappeningMapper getHappeningMapper() {
        return happeningMapper;
    }

    public void setHappeningMapper(HappeningMapper happeningMapper) {
        this.happeningMapper = happeningMapper;
    }
}
