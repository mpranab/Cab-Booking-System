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

import com.auth.entity.Driver;
import com.auth.exceptionHandler.DriverAlreadyExistException;
import com.auth.exceptionHandler.DriverNotFoundException;

@FeignClient(name = "driverService", url = "http://localhost:8082/")
public interface DriverClient {
    
    @PostMapping("/drivers/addDriver")
    public Driver addDriver(@RequestBody Driver driver) throws DriverAlreadyExistException;

    @GetMapping("/drivers/{id}")
    public Driver findByNumber(@PathVariable Long id) throws DriverNotFoundException;

    @GetMapping("/drivers")
    public List<Driver> getAll();

    @DeleteMapping("/drivers/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) throws DriverNotFoundException;

    @PutMapping("/drivers/{id}")
    public Driver updateDriver(@PathVariable("id") Long id, @RequestBody Driver driver) throws DriverNotFoundException;
}
