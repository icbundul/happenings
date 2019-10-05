package com.nativehappenings.happenings.api;

import com.nativehappenings.happenings.api.viewmodel.HappeningPlaceViewModel;
import com.nativehappenings.happenings.exceptions.HappeningPlaceValidationException;
import com.nativehappenings.happenings.mapper.HappeningPlaceMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.model.HappeningPlace;
import com.nativehappenings.happenings.services.HappeningPlaceService;
import com.nativehappenings.happenings.services.HappeningService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/happeningplaces")
@CrossOrigin
public class HappeningPlaceController {

    private HappeningPlaceService happeningPlaceService;
    private HappeningService happeningService;
    private HappeningPlaceMapper happeningPlaceMapper;

    public HappeningPlaceController(HappeningPlaceService happeningPlaceService, HappeningService happeningService, HappeningPlaceMapper happeningPlaceMapper) {
        this.happeningPlaceService = happeningPlaceService;
        this.happeningService = happeningService;
        this.happeningPlaceMapper = happeningPlaceMapper;
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

    @GetMapping("/{happeningId}")
    public List<HappeningPlaceViewModel> byHappening(@PathVariable Long happeningId) {
        List<HappeningPlace> happeningPlaces = new ArrayList<>();

        Happening happening = this.happeningService.find(happeningId);

        if (happening != null) {
            happeningPlaces = this.happeningPlaceService.findAllByHappening(happening);
        }
        // map to note view model
        List<HappeningPlaceViewModel> happeningPlacesViewModels = happeningPlaces.stream()
                .map(happeningPlace -> this.happeningPlaceMapper.convertToModel(happeningPlace))
                .collect(Collectors.toList());

        return happeningPlacesViewModels;
    }

    @PostMapping
    public HappeningPlace save(@RequestBody HappeningPlaceViewModel happeningPlaceViewModel, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new HappeningPlaceValidationException();
        }

        HappeningPlace happeningPlaceEntity = this.happeningPlaceMapper.convertToEntity(happeningPlaceViewModel);

        // save note instance to db
        this.happeningPlaceService.save(happeningPlaceEntity);

        return happeningPlaceEntity;
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
