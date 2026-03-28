package com.miniedu.exception.common;

import com.miniedu.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public class ServiceUnavailableException extends ApplicationException {

    public ServiceUnavailableException(String serviceName) {
        super(
                "SERVICE_UNAVAILABLE",
                "Service '" + serviceName + "' is temporarily unavailable",
                HttpStatus.SERVICE_UNAVAILABLE
        );
    }

    public static ServiceUnavailableException fromService(String serviceName) {
        return new ServiceUnavailableException(serviceName);
    }
}