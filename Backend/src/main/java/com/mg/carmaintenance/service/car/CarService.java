package com.mg.carmaintenance.service.car;

import com.mg.carmaintenance.dto.car.CarResponse;
import com.mg.carmaintenance.dto.car.CreateCarRequest;
import com.mg.carmaintenance.dto.car.UpdateCarRequest;
import com.mg.carmaintenance.common.NotFoundException;
import com.mg.carmaintenance.domain.entity.Car;
import com.mg.carmaintenance.repository.car.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class CarService {

    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public CarResponse create(CreateCarRequest req) {
        Car car = new Car();
        car.setMake(req.make());
        car.setModel(req.model());
        car.setYear(req.year());
        car.setVin(blankToNull(req.vin()));
        car.setLicensePlate(blankToNull(req.licensePlate()));

        Car saved = repo.save(car);
        return toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<CarResponse> list() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public CarResponse get(UUID id) {
        Car car = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found: " + id));
        return toResponse(car);
    }

    @Transactional
    public CarResponse update(UUID id, UpdateCarRequest req) {
        Car car = repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Car not found: " + id));

        car.setMake(req.make());
        car.setModel(req.model());
        car.setYear(req.year());
        car.setVin(blankToNull(req.vin()));
        car.setLicensePlate(blankToNull(req.licensePlate()));

        Car saved = repo.save(car);
        return toResponse(saved);
    }

    @Transactional
    public void delete(UUID id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Car not found: " + id);
        }
        repo.deleteById(id);
    }

    private CarResponse toResponse(Car c) {
        return new CarResponse(
                c.getId(),
                c.getMake(),
                c.getModel(),
                c.getYear(),
                c.getVin(),
                c.getLicensePlate(),
                c.getCreatedAt(),
                c.getUpdatedAt()
        );
    }

    private static String blankToNull(String s) {
        if (s == null) return null;
        String t = s.trim();
        return t.isEmpty() ? null : t;
    }
}
