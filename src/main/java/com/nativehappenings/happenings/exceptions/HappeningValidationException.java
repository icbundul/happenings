package com.nativehappenings.happenings.exceptions;

import javax.validation.ValidationException;

public class HappeningValidationException extends ValidationException {

    public HappeningValidationException(String message) {
        super(message);
    }

    public HappeningValidationException() {
    }

    public HappeningValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public HappeningValidationException(Throwable cause) {
        super(cause);
    }
}
