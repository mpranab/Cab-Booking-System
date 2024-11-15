package com.auth.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auth.client.BookingClient;
import com.auth.entity.BookingDetail;

@RestController
public class BookingController {

    @Autowired
    private BookingClient bookingService;

    @PostMapping("/bookings/addBooking")
    public ResponseEntity<BookingDetail> createBooking(@RequestBody BookingDetail booking) {
        BookingDetail createdBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<BookingDetail> getBookingById(@PathVariable Long id) {
        BookingDetail booking = bookingService.getBookingById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PutMapping("/bookings/{id}/end-ride")
    public ResponseEntity<Void> endRide(@PathVariable Long id) {
        bookingService.endRide(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/bookings")
    public ResponseEntity<List<BookingDetail>> getAllBookings() {
        List<BookingDetail> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/bookings/search/{pickupPoint}/{dropPoint}")
    public ResponseEntity<List<BookingDetail>> getBookingsByPickupDrop(@PathVariable String pickupPoint, @PathVariable String dropPoint) {
        List<BookingDetail> bookings = bookingService.getBookingsByPickupDrop(pickupPoint, dropPoint);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/bookings/time/{startTime}/{endTime}")
    public ResponseEntity<List<BookingDetail>> getBookingsBetweenTimes(@PathVariable String startTime, @PathVariable String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);
        List<BookingDetail> bookings = bookingService.getBookingsBetweenTimes(start, end);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/bookings/car/{carId}")
    public ResponseEntity<List<BookingDetail>> getAllBookingsByCarId(@PathVariable Long carId) {
        List<BookingDetail> bookings = bookingService.getAllBookingsByCabId(carId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
}


