package com.mg.carmaintenance.repository.fuel;

import com.mg.carmaintenance.domain.entity.FuelEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelEntryRepository extends JpaRepository<FuelEntry, UUID> {
}
