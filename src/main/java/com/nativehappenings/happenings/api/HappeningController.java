package com.nativehappenings.happenings.api;

import com.nativehappenings.happenings.api.viewmodel.HappeningTypeViewModel;
import com.nativehappenings.happenings.api.viewmodel.HappeningViewModel;
import com.nativehappenings.happenings.exceptions.HappeningValidationException;
import com.nativehappenings.happenings.mapper.HappeningMapper;
import com.nativehappenings.happenings.model.Happening;
import com.nativehappenings.happenings.services.HappeningService;
import com.nativehappenings.happenings.util.FieldErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<Happening> savePost(@RequestBody HappeningViewModel happeningViewModel, BindingResult bindingResult) {

        return save (happeningViewModel, bindingResult);
    }

    @PutMapping("/")
    @Transactional
    public ResponseEntity<Happening> savePut(@RequestBody HappeningViewModel happeningViewModel, BindingResult bindingResult) {

        return save (happeningViewModel, bindingResult);
    }

    public ResponseEntity<Happening> save(@RequestBody HappeningViewModel happeningViewModel, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            throw new HappeningValidationException();
        }

        Happening happeningEntity = this.happeningMapper.convertToEntity(happeningViewModel);

        // save entity to database
        return new ResponseEntity(this.happeningService.save(happeningEntity), HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    List<FieldErrorMessage> exceptionHandler(MethodArgumentNotValidException e) {

        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<FieldErrorMessage> fieldErrorMessages = fieldErrors.stream()
                .map(fieldError -> new FieldErrorMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                .collect(Collectors.toList());

        return fieldErrorMessages;
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
