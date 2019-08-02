package com.nativehappenings.happenings.api;

import com.nativehappenings.happenings.api.viewmodel.PlaceOfInterestViewModel;
import com.nativehappenings.happenings.exceptions.PlaceOfInterestValidationException;
import com.nativehappenings.happenings.mapper.PlaceOfInterestMapper;
import com.nativehappenings.happenings.model.PlaceOfInterest;
import com.nativehappenings.happenings.services.PlaceOfInterestService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/placeofinterest")
@CrossOrigin
public class PlaceOfInterestController {

    private PlaceOfInterestService placeOfInterestService;

    private PlaceOfInterestMapper placeOfInterestMapper;

    public PlaceOfInterestController(PlaceOfInterestService placeOfInterestService, PlaceOfInterestMapper placeOfInterestMapper) {
        this.placeOfInterestService = placeOfInterestService;
        this.placeOfInterestMapper = placeOfInterestMapper;
    }

    @GetMapping("/all")
    public List<PlaceOfInterest> all() {
        List<PlaceOfInterest> allPlaceOfInterests = placeOfInterestService.findAll();
        return allPlaceOfInterests;
    }

    @PostMapping
    @Transactional
    public PlaceOfInterest save(@RequestBody PlaceOfInterestViewModel placeOfInterestViewModel, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            throw new PlaceOfInterestValidationException();
        }

        PlaceOfInterest placeOfInterestEntity = this.placeOfInterestMapper.convertToEntity(placeOfInterestViewModel);

        // save entity to database
        this.placeOfInterestService.save(placeOfInterestEntity);

        return placeOfInterestEntity;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        this.placeOfInterestService.deleteById(id);
    }


}
