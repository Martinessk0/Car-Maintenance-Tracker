package com.mg.carmaintenance.common;

/**
 * Thrown when a requested resource is not found.
 * We map it to HTTP 404 via {@link RestExceptionHandler}.
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
