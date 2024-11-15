package com.auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Driver_Service")
public class Driver {

    @Id
    private Long driverId;
    private String name;
    private Long mobNumber;
    private String licenseNo;

    // Getters and Setters
    public Long getDriverId() {  // Correct getter method name
        return driverId;
    }

    public void setDriverId(Long driverId) {  // Correct setter method name
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(Long mobNumber) {
        this.mobNumber = mobNumber;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }
}
