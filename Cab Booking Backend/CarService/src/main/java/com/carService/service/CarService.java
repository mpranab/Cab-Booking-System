package com.carService.service;

import java.util.List;

import com.carService.entity.Car;
import com.carService.entity.CarCategory;

public interface CarService {
	Car addCar(Car car);
	Car updateCar(Long id, Car carDetails);
    void deleteCar(Long id);
    Car getCarById(Long id);
    List<Car> getAllCars();
    List<Car> getAvailableCars();
    List<Car> getCarsByCategory(CarCategory category);
    List<Car> getCarsByDriverId(Long driverId);
}
