package com.mg.carmaintenance.common;

import java.time.Instant;

/**
 * Unified error response body.
 * (Keeps frontend error handling consistent.)
 */
public record ErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path
) {
}
