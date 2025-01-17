package com.driverService.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.driverService.entity.Driver;
import com.driverService.exception.DriverAlreadyExistException;
import com.driverService.exception.DriverNotFoundException;
import com.driverService.repository.DriverRepository;

class DriverServiceImplTest {

    @Mock
    private DriverRepository driverRepository;

    @InjectMocks
    private DriverServiceImpl driverService;

    private Driver driver;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        
        driver = new Driver();
        driver.setDriverId(1L);
        driver.setName("ABC");
        driver.setMobNumber(7865438908L);
        driver.setLicenseNo("ABC12345");
    }

    @Test
    void testAddDriver_Success() throws DriverAlreadyExistException {
        when(driverRepository.findByMobNumber(driver.getMobNumber())).thenReturn(Optional.empty());
        when(driverRepository.save(driver)).thenReturn(driver);

        Driver createdDriver = driverService.addDriver(driver);

        assertNotNull(createdDriver);
        assertEquals("ABC", createdDriver.getName());
        verify(driverRepository, times(1)).save(driver);
    }

    @Test
    void testAddDriver_AlreadyExists() {
        when(driverRepository.findByMobNumber(driver.getMobNumber())).thenReturn(Optional.of(driver));

        assertThrows(DriverAlreadyExistException.class, () -> driverService.addDriver(driver));
        verify(driverRepository, never()).save(driver);
    }

    @Test
    void testFindByNumber_Success() throws DriverNotFoundException {
        when(driverRepository.findById(driver.getDriverId())).thenReturn(Optional.of(driver));

        Driver foundDriver = driverService.findByNumber(driver.getDriverId());

        assertNotNull(foundDriver);
        assertEquals("ABC", foundDriver.getName());
        verify(driverRepository, times(1)).findById(driver.getDriverId());
    }

    @Test
    void testFindByNumber_NotFound() {
        when(driverRepository.findById(driver.getDriverId())).thenReturn(Optional.empty());

        assertThrows(DriverNotFoundException.class, () -> driverService.findByNumber(driver.getDriverId()));
        verify(driverRepository, times(1)).findById(driver.getDriverId());
    }

    @Test
    void testGetAllDrivers() {
        List<Driver> driverList = new ArrayList<>();
        driverList.add(driver);
        when(driverRepository.findAll()).thenReturn(driverList);

        List<Driver> allDrivers = driverService.getAll();

        assertNotNull(allDrivers);
        assertEquals(1, allDrivers.size());
        verify(driverRepository, times(1)).findAll();
    }

    @Test
    void testDeleteById_Success() throws DriverNotFoundException {
        when(driverRepository.findById(driver.getDriverId())).thenReturn(Optional.of(driver));

        boolean isDeleted = driverService.deleteById(driver.getDriverId());

        assertTrue(isDeleted);
        verify(driverRepository, times(1)).delete(driver);
    }

    @Test
    void testDeleteById_NotFound() {
        when(driverRepository.findById(driver.getDriverId())).thenReturn(Optional.empty());

        assertThrows(DriverNotFoundException.class, () -> driverService.deleteById(driver.getDriverId()));
        verify(driverRepository, never()).delete(driver);
    }

    @Test
    void testUpdateDriver_Success() throws DriverNotFoundException {
        Driver updatedDriver = new Driver();
        updatedDriver.setDriverId(1L);
        updatedDriver.setName("XYZ");
        updatedDriver.setMobNumber(9876543210L);
        updatedDriver.setLicenseNo("XYZ98765");

        when(driverRepository.findById(driver.getDriverId())).thenReturn(Optional.of(driver));
        when(driverRepository.save(driver)).thenReturn(updatedDriver);

        Driver result = driverService.updateDriver(driver.getDriverId(), updatedDriver);

        assertNotNull(result);
        assertEquals("XYZ", result.getName());
        assertEquals(9876543210L, result.getMobNumber());
        verify(driverRepository, times(1)).save(driver);
    }

    @Test
    void testUpdateDriver_NotFound() {
        when(driverRepository.findById(driver.getDriverId())).thenReturn(Optional.empty());

        Driver updatedDriver = new Driver();
        updatedDriver.setDriverId(1L);
        updatedDriver.setName("Jane Doe");

        assertThrows(DriverNotFoundException.class, () -> driverService.updateDriver(driver.getDriverId(), updatedDriver));
        verify(driverRepository, never()).save(updatedDriver);
    }
}