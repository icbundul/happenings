package com.nativehappenings.happenings.exceptions;

import javax.validation.ValidationException;

public class HappeningPlaceValidationException extends ValidationException {

    public HappeningPlaceValidationException(String message) {
        super(message);
    }

    public HappeningPlaceValidationException() {
    }

    public HappeningPlaceValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HappeningPlaceValidationException(Throwable cause) {
        super(cause);
    }
}
