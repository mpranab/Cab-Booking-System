package com.driverService.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.driverService.entity.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {

	Optional<Driver> findByMobNumber(Long mobNumber);

}
