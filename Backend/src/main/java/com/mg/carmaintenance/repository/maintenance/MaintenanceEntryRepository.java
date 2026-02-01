package com.mg.carmaintenance.repository.maintenance;

import com.mg.carmaintenance.domain.entity.MaintenanceEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MaintenanceEntryRepository extends JpaRepository<MaintenanceEntry, UUID> {
}
