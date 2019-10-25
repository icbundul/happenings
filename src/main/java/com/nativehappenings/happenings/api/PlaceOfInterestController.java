package com.nativehappenings.happenings.api;

import com.nativehappenings.happenings.api.viewmodel.PlaceOfInterestViewModel;
import com.nativehappenings.happenings.exceptions.PlaceOfInterestValidationException;
import com.nativehappenings.happenings.mapper.PlaceOfInterestMapper;
import com.nativehappenings.happenings.model.PlaceOfInterest;
import com.nativehappenings.happenings.services.PlaceOfInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.Valid;
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

    @PostMapping("/")
    @Transactional
    public ResponseEntity<PlaceOfInterest> savePost(@Valid @RequestBody PlaceOfInterest placeOfInterest, BindingResult bindingResult) {

        return save (placeOfInterest, bindingResult);
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<PlaceOfInterest> savePut(@Valid @RequestBody PlaceOfInterest placeOfInterest, BindingResult bindingResult) {

        return save (placeOfInterest, bindingResult);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PlaceOfInterest> save(@RequestBody PlaceOfInterest placeOfInterest, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            throw new PlaceOfInterestValidationException(bindingResult.getAllErrors().toString());
        }

        // save entity to database
        return new ResponseEntity<PlaceOfInterest>(this.placeOfInterestService.save(placeOfInterest), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public PlaceOfInterestViewModel byId(@PathVariable Long id) {

        PlaceOfInterest placeOfInterest = placeOfInterestService.find(id);

        if (placeOfInterest == null) {
            // TODO To much Exceptions for EntityNotFoundException, figure out what to do with this.
            throw new EntityNotFoundException(placeOfInterest.getClass().getSimpleName());
        }

        return this.placeOfInterestMapper.convertToModel(placeOfInterest);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        this.placeOfInterestService.deleteById(id);
    }
}
