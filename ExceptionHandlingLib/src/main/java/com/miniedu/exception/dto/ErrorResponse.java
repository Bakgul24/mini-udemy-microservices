package com.miniedu.exception.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private String code;
    private String message;
    private int status;
    private LocalDateTime timestamp;
    private String path;
    private String serviceName;
    private Map<String, String> validationErrors;
    private String errorId;
    private String traceId;

    public ErrorResponse() {
    }

    public ErrorResponse(String code, String message, int status, LocalDateTime timestamp,
                         String path, String serviceName, Map<String, String> validationErrors,
                         String errorId, String traceId) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.path = path;
        this.serviceName = serviceName;
        this.validationErrors = validationErrors;
        this.errorId = errorId;
        this.traceId = traceId;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Map<String, String> getValidationErrors() {
        return validationErrors;
    }

    public String getErrorId() {
        return errorId;
    }

    public String getTraceId() {
        return traceId;
    }

    // Setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setValidationErrors(Map<String, String> validationErrors) {
        this.validationErrors = validationErrors;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public static ErrorResponseBuilder builder() {
        return new ErrorResponseBuilder();
    }

    public static class ErrorResponseBuilder {
        private String code;
        private String message;
        private int status;
        private LocalDateTime timestamp;
        private String path;
        private String serviceName;
        private Map<String, String> validationErrors;
        private String errorId;
        private String traceId;

        public ErrorResponseBuilder code(String code) {
            this.code = code;
            return this;
        }

        public ErrorResponseBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponseBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ErrorResponseBuilder timestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorResponseBuilder path(String path) {
            this.path = path;
            return this;
        }

        public ErrorResponseBuilder serviceName(String serviceName) {
            this.serviceName = serviceName;
            return this;
        }

        public ErrorResponseBuilder validationErrors(Map<String, String> validationErrors) {
            this.validationErrors = validationErrors;
            return this;
        }

        public ErrorResponseBuilder errorId(String errorId) {
            this.errorId = errorId;
            return this;
        }

        public ErrorResponseBuilder traceId(String traceId) {
            this.traceId = traceId;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(code, message, status, timestamp, path,
                    serviceName, validationErrors, errorId, traceId);
        }
    }
}