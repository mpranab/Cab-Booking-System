package com.bookingService.entity;

import java.math.BigInteger;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Car_Service")
public class Car {

    @Id
    private Long carId;

    private String carNumber;

    @Enumerated(EnumType.STRING)
    private CarCategory carCategory;

    private BigInteger rateHour;

    private Boolean available;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id", referencedColumnName = "driverId")
    private Driver driver; // The driver assigned to this cab

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    // Update getter and setter for carId
    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public void setRateHour(BigInteger rateHour) {
        this.rateHour = rateHour;
    }

    public BigInteger getRateHour() {
        return rateHour;
    }

    public Car() {
    }
}