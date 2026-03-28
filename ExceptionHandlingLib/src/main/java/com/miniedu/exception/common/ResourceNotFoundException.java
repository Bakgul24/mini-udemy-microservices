package com.miniedu.exception.common;

import com.miniedu.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends ApplicationException {

    public ResourceNotFoundException(String resource, String identifier) {
        super(
                "RESOURCE_NOT_FOUND",
                resource + " with identifier '" + identifier + "' not found",
                HttpStatus.NOT_FOUND
        );
    }

    public static ResourceNotFoundException byId(String resource, Long id) {
        return new ResourceNotFoundException(resource, "id: " + id);
    }

    public static ResourceNotFoundException byId(String resource, Integer id) {
        return new ResourceNotFoundException(resource, "id: " + id);
    }

    public static ResourceNotFoundException byEmail(String resource, String email) {
        return new ResourceNotFoundException(resource, "email: " + email);
    }

    public static ResourceNotFoundException byName(String resource, String name) {
        return new ResourceNotFoundException(resource, "name: " + name);
    }

    public static ResourceNotFoundException byCode(String resource, String code) {
        return new ResourceNotFoundException(resource, "code: " + code);
    }
}