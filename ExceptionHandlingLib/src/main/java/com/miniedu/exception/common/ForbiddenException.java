package com.miniedu.exception.common;

import com.miniedu.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ForbiddenException extends ApplicationException {

    public ForbiddenException(String message) {
        super(
                "FORBIDDEN",
                message,
                HttpStatus.FORBIDDEN
        );
    }

    public static ForbiddenException accessDenied(String resource) {
        return new ForbiddenException("Access denied to " + resource);
    }

    public static ForbiddenException insufficientPermissions() {
        return new ForbiddenException("You don't have permission to perform this action");
    }
}
