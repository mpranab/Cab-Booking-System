package com.driverService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driverService.entity.Driver;
import com.driverService.exception.DriverAlreadyExistException;
import com.driverService.exception.DriverNotFoundException;
import com.driverService.repository.DriverRepository;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	private DriverRepository driverRepository;

	@Override
	public Driver addDriver(Driver driver) throws DriverAlreadyExistException {
		Optional<Driver> existingDriver = driverRepository.findByMobNumber(driver.getMobNumber());
		if (existingDriver.isPresent()) {
			throw new DriverAlreadyExistException(
					"Driver with mobile number " + driver.getMobNumber() + " already exists.");
		}
		return driverRepository.save(driver);
	}

	@Override
	public Driver findByNumber(long id) throws DriverNotFoundException {
		return driverRepository.findById(id)
				.orElseThrow(() -> new DriverNotFoundException("Driver with driverId " + id + " not found."));
	}

	@Override
	public List<Driver> getAll() {
		return driverRepository.findAll();
	}

	@Override
	public boolean deleteById(long id) throws DriverNotFoundException {
		Driver driver = driverRepository.findById(id)
				.orElseThrow(() -> new DriverNotFoundException("Driver with ID " + id + " not found."));
		driverRepository.delete(driver);
		return true;
	}

	@Override
	public Driver updateDriver(Long id,Driver driver) throws DriverNotFoundException {
		Driver existingDriver = driverRepository.findById(driver.getDriverId())
				.orElseThrow(() -> new DriverNotFoundException("Driver with ID " + driver.getDriverId() + " not found."));

		existingDriver.setName(driver.getName());
		existingDriver.setMobNumber(driver.getMobNumber());
		existingDriver.setLicenseNo(driver.getLicenseNo());

		return driverRepository.save(existingDriver);
	}
}
