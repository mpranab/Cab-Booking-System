package com.carService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carService.entity.Car;
import com.carService.entity.CarCategory;
import com.carService.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService {
	private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car carDetails) {
        Optional<Car> existingCab = carRepository.findById(id);
        if (existingCab.isPresent()) {
        	Car cab = existingCab.get();
            cab.setCarNumber(carDetails.getCarNumber());
            cab.setCarCategory(carDetails.getCarCategory());
            cab.setRateHour(carDetails.getRateHour());
            cab.setAvailable(carDetails.getAvailable());
            cab.setDriver(carDetails.getDriver());
            return carRepository.save(carDetails);
        } else {
            throw new RuntimeException("Cab not found with id: " + id);
        }
    }

    @Override
    public void deleteCar(Long id) {
    	carRepository.deleteById(id);
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cab not found with id: " + id));
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> getAvailableCars() {
        return carRepository.findByAvailable(true);
    }

    @Override
    public List<Car> getCarsByCategory(CarCategory carCategory) {
        return carRepository.findByCarCategory(carCategory);
    }

    @Override
    public List<Car> getCarsByDriverId(Long driverId) {
        return carRepository.findByDriver_DriverId(driverId);
    }
}