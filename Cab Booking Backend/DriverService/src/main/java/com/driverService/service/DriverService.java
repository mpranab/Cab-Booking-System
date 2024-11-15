package com.driverService.service;

import java.util.List;

import com.driverService.entity.Driver;
import com.driverService.exception.DriverAlreadyExistException;
import com.driverService.exception.DriverNotFoundException;

public interface DriverService {

	public Driver addDriver(Driver driver) throws DriverAlreadyExistException;

	public Driver findByNumber(long driverNo) throws DriverNotFoundException;

	public List<Driver> getAll();

	public boolean deleteById(long driverNo) throws DriverNotFoundException;

	public Driver updateDriver(Long id,Driver driver) throws DriverNotFoundException;

	//public Driver updateDriver(Long id, Driver driver);

}
