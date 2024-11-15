package com.auth.client;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.auth.entity.BookingDetail;

@FeignClient(name = "bookingService", url = "http://localhost:8083/")
public interface BookingClient {

	@PostMapping("/bookings/addBooking")
	public BookingDetail createBooking(@RequestBody BookingDetail booking);

	@GetMapping("/bookings/{id}")
	public BookingDetail getBookingById(@PathVariable Long id);

	@PutMapping("/bookings/{id}/end-ride")
	public ResponseEntity<?> endRide(@PathVariable Long id);

	@GetMapping("/bookings")
	public List<BookingDetail> getAllBookings();

	@GetMapping("/bookings/search/{pickupPoint}/{dropPoint}")
	public List<BookingDetail> getBookingsByPickupDrop(@PathVariable String pickupPoint,
			@PathVariable String dropPoint);

	@GetMapping("/bookings/time")
	public List<BookingDetail> getBookingsBetweenTimes(@RequestParam LocalDateTime start,
			@RequestParam LocalDateTime end);

	@GetMapping("/bookings/car/{id}")
	public List<BookingDetail> getAllBookingsByCabId(@PathVariable Long id);
}
