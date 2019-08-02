package com.nativehappenings.happenings.exceptions;

import javax.validation.ValidationException;

public class PlaceOfInterestValidationException extends ValidationException {

    public PlaceOfInterestValidationException(String message) {
        super(message);
    }

    public PlaceOfInterestValidationException() {
    }

    public PlaceOfInterestValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlaceOfInterestValidationException(Throwable cause) {
        super(cause);
    }
}
