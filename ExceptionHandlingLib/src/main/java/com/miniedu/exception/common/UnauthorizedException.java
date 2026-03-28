package com.miniedu.exception.common;

import com.miniedu.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class UnauthorizedException extends ApplicationException {

    public UnauthorizedException(String message) {
        super(
                "UNAUTHORIZED",
                message,
                HttpStatus.UNAUTHORIZED
        );
    }

    public static UnauthorizedException missingToken() {
        return new UnauthorizedException("Authentication token is missing");
    }

    public static UnauthorizedException invalidToken() {
        return new UnauthorizedException("Authentication token is invalid or expired");
    }

    public static UnauthorizedException invalidCredentials() {
        return new UnauthorizedException("Invalid credentials");
    }
}
