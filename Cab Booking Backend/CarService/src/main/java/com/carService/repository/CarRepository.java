package com.carService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carService.entity.Car;
import com.carService.entity.CarCategory;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
	
    List<Car> findByAvailable(Boolean available);
    List<Car> findByCarCategory(CarCategory carCategory);
    List<Car> findByDriver_DriverId(Long driverId);
    
}
