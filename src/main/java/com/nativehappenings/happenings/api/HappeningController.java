package com.nativehappenings.happenings.api;

import com.nativehappenings.happenings.api.viewmodel.HappeningTypeViewModel;
import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.exceptions.HappeningValidationException;
import com.nativehappenings.happenings.mapper.HappeningMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.services.HappeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/all")
    public List<HappeningViewModel> all() {
        return happeningMapper.convertViewModelListFromEntityList(happeningService.findAll());
    }

    @GetMapping("/allHappeningTypes")
    public List<HappeningTypeViewModel> allHappeningTypes() {
        return happeningMapper.convertTypeViewModelListFromTypeEntityList(happeningService.findAllHappeningTypes());
    }

    @GetMapping("/{id}")
    public HappeningViewModel byId(@PathVariable Long id) {

        Happening happening = happeningService.find(id);

        if (happening == null) {
            return null;
            // TODO To much Exceptions for EntityNotFoundException, figure out what to do with this.
            //throw new EntityNotFoundException();
        }

        return this.happeningMapper.convertToModel(happening);
    }

    @PostMapping("/")
    @Transactional
    public Happening savePost(@RequestBody HappeningViewModel happeningViewModel, BindingResult bindingResult) {

        return save (happeningViewModel, bindingResult);
    }

    @PutMapping("/")
    @Transactional
    public Happening savePut(@RequestBody HappeningViewModel happeningViewModel, BindingResult bindingResult) {

        return save (happeningViewModel, bindingResult);
    }

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

    @GetMapping("/search")
    public List<Happening> getAllHappeningsByNameContains(HttpServletRequest request) {
        return happeningService.findByNameContains(request.getParameter("name"));
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
