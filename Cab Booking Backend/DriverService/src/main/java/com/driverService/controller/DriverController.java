package com.driverService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.driverService.entity.Driver;
import com.driverService.exception.DriverAlreadyExistException;
import com.driverService.exception.DriverNotFoundException;
import com.driverService.service.DriverService;

@RestController
@RequestMapping("/drivers")
public class DriverController {

    @Autowired
    private DriverService driverService;

    @PostMapping("/addDriver")
    public ResponseEntity<Driver> addDriver(@RequestBody Driver driver) {
        try {
            Driver newDriver = driverService.addDriver(driver);
            return new ResponseEntity<>(newDriver, HttpStatus.CREATED);
        } catch (DriverAlreadyExistException e) {
            return new ResponseEntity<>(null, HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Driver> getDriverById(@PathVariable Long id) {
        try {
            Driver driver = driverService.findByNumber(id);
            return new ResponseEntity<>(driver, HttpStatus.OK);
        } catch (DriverNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Driver>> getAllDrivers() {
        List<Driver> drivers = driverService.getAll();
        return new ResponseEntity<>(drivers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriverById(@PathVariable Long id) {
        try {
            driverService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (DriverNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Driver> updateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) {
        try {
            driver.setDriverId(id);
            Driver updatedDriver = driverService.updateDriver(id,driver);
            return new ResponseEntity<>(updatedDriver, HttpStatus.OK);
        } catch (DriverNotFoundException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
