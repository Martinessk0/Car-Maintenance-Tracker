package com.mg.carmaintenance.dto.car;

import java.time.Instant;
import java.util.UUID;

/**
 * DTO returned to the client.
 */
public record CarResponse(
        UUID id,
        String make,
        String model,
        Integer year,
        String vin,
        String licensePlate,
        Instant createdAt,
        Instant updatedAt
) {
}
