package com.mg.carmaintenance.domain.entity;

import com.mg.carmaintenance.domain.enums.Currency;
import com.mg.carmaintenance.domain.enums.FuelType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "fuel_entries")
@Getter
@Setter
public class FuelEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private Integer odometerKm;

    @Column(nullable = false, precision = 12, scale = 3)
    private BigDecimal liters;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal totalCost;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FuelType fuelType;
}
