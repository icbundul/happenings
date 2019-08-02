package com.nativehappenings.happenings.api;

import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.exceptions.HappeningValidationException;
import com.nativehappenings.happenings.mapper.HappeningMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.services.HappeningService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/happenings")
@CrossOrigin
public class HappeningController {

    //@Autowired
    private HappeningService happeningService;

    //@Autowired
    private HappeningMapper happeningMapper;

    public HappeningController(HappeningService happeningService, HappeningMapper happeningMapper) {
        this.happeningService = happeningService;
        this.happeningMapper = happeningMapper;
    }

    @GetMapping("/all")
    public List<Happening> all() {
        List<Happening> allHappenings = happeningService.findAll();
        return allHappenings;
    }

    @PostMapping
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
