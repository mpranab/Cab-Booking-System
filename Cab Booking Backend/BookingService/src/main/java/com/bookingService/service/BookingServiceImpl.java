package com.bookingService.service;

import com.bookingService.entity.BookingDetail;
import com.bookingService.exception.BookingNotFoundException;
import com.bookingService.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public BookingDetail createBooking(BookingDetail booking) {
        booking.setPickupTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }

    @Override
    public BookingDetail getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking not found"));
    }

    @Override
    public void endRide(Long bookingId) {
        BookingDetail booking = getBookingById(bookingId);
        booking.setDropTime(LocalDateTime.now());
        bookingRepository.save(booking);
    }

    @Override
    public List<BookingDetail> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public List<BookingDetail> getBookingsByPickupDrop(String pickupPoint, String dropPoint) {
        return bookingRepository.findByPickupPointAndDropPoint(pickupPoint, dropPoint);
    }

    @Override
    public List<BookingDetail> getBookingsBetweenTimes(LocalDateTime startTime, LocalDateTime endTime) {
        return bookingRepository.findByPickupTimeBetween(startTime, endTime);
    }

    @Override
    public List<BookingDetail> getAllBookingsByCarId(Long carId) {
        return bookingRepository.findByCarId(carId);
    }

	@Override
	public List<BookingDetail> getBookingsByUserName(String firstName, String lastName) {
		return bookingRepository.findByUserFirstNameOrUserLastName(firstName, lastName);
	}
    
}
