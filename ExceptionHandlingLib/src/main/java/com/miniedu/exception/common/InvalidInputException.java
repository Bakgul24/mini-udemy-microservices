package com.miniedu.exception.common;

import com.miniedu.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class InvalidInputException extends ApplicationException {

    public InvalidInputException(String fieldName, String message) {
        super(
                "INVALID_INPUT",
                "Invalid " + fieldName + ": " + message,
                HttpStatus.BAD_REQUEST
        );
    }

    public static InvalidInputException nullField(String fieldName) {
        return new InvalidInputException(fieldName, fieldName + " cannot be null or empty");
    }

    public static InvalidInputException emptyField(String fieldName) {
        return new InvalidInputException(fieldName, fieldName + " cannot be empty");
    }

    public static InvalidInputException invalidValue(String fieldName, String expectedFormat) {
        return new InvalidInputException(fieldName, "expected " + expectedFormat);
    }

    public static InvalidInputException invalidRange(String fieldName, String range) {
        return new InvalidInputException(fieldName, "must be " + range);
    }

    public static InvalidInputException invalidFormat(String fieldName, String format) {
        return new InvalidInputException(fieldName, "must be in format: " + format);
    }
}
