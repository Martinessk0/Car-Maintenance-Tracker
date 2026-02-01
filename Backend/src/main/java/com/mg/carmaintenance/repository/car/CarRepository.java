package com.mg.carmaintenance.repository.car;

import com.mg.carmaintenance.domain.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
    boolean existsByVin(String vin);
    boolean existsByLicensePlate(String licensePlate);
}
