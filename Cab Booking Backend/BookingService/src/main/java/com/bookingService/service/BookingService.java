package com.bookingService.service;

import java.time.LocalDateTime;
import java.util.List;
import com.bookingService.entity.BookingDetail;

public interface BookingService {

	BookingDetail createBooking(BookingDetail booking);

	BookingDetail getBookingById(Long id);

	void endRide(Long bookingId);

	List<BookingDetail> getAllBookings();

	List<BookingDetail> getBookingsByPickupDrop(String pickupPoint, String dropPoint);

	List<BookingDetail> getBookingsBetweenTimes(LocalDateTime startTime, LocalDateTime endTime);

	List<BookingDetail> getAllBookingsByCarId(Long carId);  
	
	List<BookingDetail> getBookingsByUserName(String firstName, String lastName);
}
