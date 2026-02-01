package com.mg.carmaintenance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CarMaintenanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarMaintenanceApplication.class, args);
    }
}
