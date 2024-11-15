package com.auth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.client.DriverClient;
import com.auth.entity.Driver;
import com.auth.exceptionHandler.DriverAlreadyExistException;
import com.auth.exceptionHandler.DriverNotFoundException;

@RestController
public class DriverController {

    @Autowired
    private DriverClient driverService;

    @PostMapping("/drivers/addDriver")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        try {
            Driver newDriver = driverService.addDriver(driver);
            return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
        } catch (DriverAlreadyExistException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/drivers/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        try {
            Driver driver = driverService.findByNumber(id);
            return new ResponseEntity<>(driver, HttpStatus.OK);
        } catch (DriverNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/drivers")
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAll();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @DeleteMapping("/drivers/{id}")
    public ResponseEntity<Void> deleteDriverById(@PathVariable Long id) {
        try {
            driverService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DriverNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/drivers/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id")Long id, @RequestBody Driver driver) {
        try {
            driver.setDriverId(id);
            Driver updatedDriver = driverService.updateDriver(id,driver);
            return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
        } catch (DriverNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
