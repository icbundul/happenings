package com.nativehappenings.happenings.api;

import com.nativehappenings.happenings.api.viewmodel.HappeningPlaceViewModel;
import com.nativehappenings.happenings.exceptions.HappeningPlaceValidationException;
import com.nativehappenings.happenings.mapper.HappeningPlaceMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningPlace;
import com.nativehappenings.happenings.services.HappeningPlaceService;
import com.nativehappenings.happenings.services.HappeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/happeningplace")
@CrossOrigin
public class HappeningPlaceController {

    @Autowired
    private HappeningPlaceService happeningPlaceService;

    @Autowired
    private HappeningPlaceMapper happeningPlaceMapper;


    public HappeningPlaceController() {

    }

    @GetMapping("/all")
    public List<HappeningPlaceViewModel> all() {
        List<HappeningPlace> happeningPlaces = this.happeningPlaceService.findAll();

        //map from entity to view model
        List<HappeningPlaceViewModel> happeningPlacesViewModel = happeningPlaces.stream()
                .map(happeningPlace -> this.happeningPlaceMapper.convertToModel(happeningPlace))
                .collect(Collectors.toList());

        return happeningPlacesViewModel;
    }

    @GetMapping("/{id}")
    public HappeningPlaceViewModel byId(@PathVariable Long id) {

        HappeningPlace happeningPlace = this.happeningPlaceService.find(id);

        if (happeningPlace == null) {
            throw new EntityNotFoundException();
        }

        HappeningPlaceViewModel happeningPlaceViewModel = this.happeningPlaceMapper.convertToModel(happeningPlace);

        return happeningPlaceViewModel;
    }

    @PostMapping("/")
    @Transactional
    public ResponseEntity<HappeningPlace> savePost(@Valid @RequestBody HappeningPlace happeningPlace, BindingResult bindingResult) {

        return save(happeningPlace, bindingResult);
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<HappeningPlace> savePut(@Valid @RequestBody HappeningPlace happeningPlace, BindingResult bindingResult) {

        return save(happeningPlace, bindingResult);
    }


    @PostMapping
    public ResponseEntity save(@RequestBody HappeningPlace happeningPlace, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new HappeningPlaceValidationException(bindingResult.getAllErrors().toString());
        }

        // save note instance to db
        return new ResponseEntity(this.happeningPlaceService.save(happeningPlace), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        this.happeningPlaceService.deleteById(id);
    }

    @GetMapping("/search")
    public List<HappeningPlace> getAllHappeningsByNameContains(HttpServletRequest request) {
        return happeningPlaceService.findAllByPlaceNameContains(request.getParameter("searchTerm"));
    }
}
