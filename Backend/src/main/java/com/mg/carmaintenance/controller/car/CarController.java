package com.mg.carmaintenance.controller.car;

import com.mg.carmaintenance.service.car.CarService;
import com.mg.carmaintenance.dto.car.CarResponse;
import com.mg.carmaintenance.dto.car.CreateCarRequest;
import com.mg.carmaintenance.dto.car.UpdateCarRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse create(@Valid @RequestBody CreateCarRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<CarResponse> list() {
        return service.list();
    }

    @GetMapping("/{id}")
    public CarResponse get(@PathVariable UUID id) {
        return service.get(id);
    }

    @PutMapping("/{id}")
    public CarResponse update(@PathVariable UUID id, @Valid @RequestBody UpdateCarRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
