package com.miniedu.exception.common;

import com.miniedu.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class InternalServerException extends ApplicationException {

    public InternalServerException(String message) {
        super(
                "INTERNAL_SERVER_ERROR",
                message,
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    public InternalServerException(String message, Throwable cause) {
        super(
                "INTERNAL_SERVER_ERROR",
                message,
                HttpStatus.INTERNAL_SERVER_ERROR,
                cause
        );
    }

    public static InternalServerException withCause(String message, Throwable cause) {
        return new InternalServerException(message, cause);
    }
}