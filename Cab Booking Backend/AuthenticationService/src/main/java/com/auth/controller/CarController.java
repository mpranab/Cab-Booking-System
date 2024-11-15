package com.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.client.CarClient;
import com.auth.entity.Car;
import com.auth.entity.CarCategory;

@RestController
public class CarController {
    @Autowired
    private CarClient carService;

    @PostMapping("/api/cars/addCar")
    public ResponseEntity<Car> addCab(@RequestBody Car car) {
        return ResponseEntity.ok(carService.addCar(car));
    }

    @PutMapping("/api/cars/{id}")
    public ResponseEntity<ResponseEntity<Car>> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        return ResponseEntity.ok(carService.updateCar(id, carDetails));
    }

    @DeleteMapping("/api/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/api/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @GetMapping("/api/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/api/cars/available")
    public ResponseEntity<List<Car>> getAvailableCars() {
        return ResponseEntity.ok(carService.getAvailableCars());
    }

    @GetMapping("/api/cars/category/{category}")
    public ResponseEntity<List<Car>> getCarsByCategory(@PathVariable CarCategory category) {
        return ResponseEntity.ok(carService.getCarsByCategory(category));
    }

    @GetMapping("/api/cars/driver/{driverId}")
    public ResponseEntity<List<Car>> getCarsByDriverId(@PathVariable Long driverId) {
        return ResponseEntity.ok(carService.getCarsByDriverId(driverId));
    }
}