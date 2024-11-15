package com.auth.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.auth.entity.Car;
import com.auth.entity.CarCategory;

@FeignClient(name = "carService", url = "http://localhost:8081/")
public interface CarClient {
    
    @PostMapping("/api/cars/addCar")
    public Car addCar(@RequestBody Car car); 

    @GetMapping("/api/cars/{id}")
    public Car getCarById(@PathVariable Long id);

    @GetMapping("/api/cars")
    public List<Car> getAllCars();
    
    @PutMapping("/api/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails);

    @DeleteMapping("/api/cars/{id}")
    public void deleteCar(@PathVariable Long id);

    @GetMapping("/api/cars/available")
    public List<Car> getAvailableCars();
    
    @GetMapping("/api/cars/category/{category}")
    public List<Car> getCarsByCategory(@PathVariable CarCategory category);
    
    @GetMapping("/api/cars/driver/{driverId}")
    public List<Car> getCarsByDriverId(@PathVariable Long driverId);
}
