package com.mg.carmaintenance.dto.car;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

/**
 * DTO for updating a car.
 */
public record UpdateCarRequest(
        @NotBlank String make,
        @NotBlank String model,
        @Positive Integer year,
        String vin,
        String licensePlate
) {
}
