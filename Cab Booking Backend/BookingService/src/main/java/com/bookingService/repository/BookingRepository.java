package com.bookingService.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bookingService.entity.BookingDetail;

@Repository
public interface BookingRepository extends JpaRepository<BookingDetail, Long> {
	
	List<BookingDetail> findByPickupPointAndDropPoint(String pickupPoint, String dropPoint);

	List<BookingDetail> findByPickupTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

	// Updated to use carId directly as a field, rather than accessing through a Car entity.
	List<BookingDetail> findByCarId(Long carId);
	
	@Query("SELECT b FROM BookingDetail b JOIN b.user u WHERE u.firstName = :firstName OR u.lastName = :lastName")
    List<BookingDetail> findByUserFirstNameOrUserLastName(String firstName, String lastName);

	
	
}
