package com.miniedu.exception.common;

import com.miniedu.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class DuplicateResourceException extends ApplicationException {

    public DuplicateResourceException(String resource, String field, String value) {
        super(
                "DUPLICATE_RESOURCE",
                resource + " with " + field + " '" + value + "' already exists",
                HttpStatus.CONFLICT
        );
    }

    public static DuplicateResourceException withEmail(String resource, String email) {
        return new DuplicateResourceException(resource, "email", email);
    }

    public static DuplicateResourceException withCode(String resource, String code) {
        return new DuplicateResourceException(resource, "code", code);
    }

    public static DuplicateResourceException withField(String resource, String field, String value) {
        return new DuplicateResourceException(resource, field, value);
    }
}