package com.bookingService.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bookingService.entity.BookingDetail;
import com.bookingService.repository.BookingRepository;
import com.bookingService.service.BookingService;

@RestController
@RequestMapping("/bookings")
@CrossOrigin(origins="*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/addBooking")
    public ResponseEntity<BookingDetail> createBooking(@RequestBody BookingDetail booking) {
        BookingDetail createdBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDetail> getBookingById(@PathVariable Long id) {
        BookingDetail booking = bookingService.getBookingById(id);
        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PutMapping("/{id}/end-ride")
    public ResponseEntity<Void> endRide(@PathVariable Long id) {
        bookingService.endRide(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookingDetail>> getAllBookings() {
        List<BookingDetail> bookings = bookingService.getAllBookings();
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/search/{pickupPoint}/{dropPoint}")
    public ResponseEntity<List<BookingDetail>> getBookingsByPickupDrop(@PathVariable String pickupPoint, @PathVariable String dropPoint) {
        List<BookingDetail> bookings = bookingService.getBookingsByPickupDrop(pickupPoint, dropPoint);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/time/{startTime}/{endTime}")
    public ResponseEntity<List<BookingDetail>> getBookingsBetweenTimes(@PathVariable String startTime, @PathVariable String endTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        LocalDateTime start = LocalDateTime.parse(startTime, formatter);
        LocalDateTime end = LocalDateTime.parse(endTime, formatter);
        List<BookingDetail> bookings = bookingService.getBookingsBetweenTimes(start, end);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<List<BookingDetail>> getAllBookingsByCarId(@PathVariable Long carId) {
        List<BookingDetail> bookings = bookingService.getAllBookingsByCarId(carId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    
    @GetMapping("/user")
    public List<BookingDetail> getBookingsByUserName(@RequestParam String firstName, @RequestParam String lastName) {
        return bookingService.getBookingsByUserName(firstName, lastName);
    }
}
