package com.mg.carmaintenance.domain.entity;

import com.mg.carmaintenance.domain.enums.Currency;
import com.mg.carmaintenance.domain.enums.MaintenanceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "maintenance_entries")
@Getter
@Setter
public class MaintenanceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(nullable = false)
    private LocalDate date;

    private Integer odometerKm;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MaintenanceType type;

    @Column(nullable = false)
    private String title;

    @Column(length = 2000)
    private String notes;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal totalCost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    private String vendor;
}
