package com.auth.entity;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking_details")
public class BookingDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	private String pickupPoint;
	private String dropPoint;
	private Date pickupDate;	
	private LocalDateTime pickupTime;
	private Date dropDate;
	private LocalDateTime dropTime;
	private long carId;

	// Association with User
	//@ManyToOne(cascade = CascadeType.ALL, optional = true)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List <User> user;

	// Getters and setters
	
	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getPickupPoint() {
		return pickupPoint;
	}

	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}

	public String getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public LocalDateTime getPickupTime() {
		return pickupTime;
	}

	public void setPickupTime(LocalDateTime pickupTime) {
		this.pickupTime = pickupTime;
	}

	public Date getDropDate() {
		return dropDate;
	}

	public void setDropDate(Date dropDate) {
		this.dropDate = dropDate;
	}

	public LocalDateTime getDropTime() {
		return dropTime;
	}

	public void setDropTime(LocalDateTime dropTime) {
		this.dropTime = dropTime;
	}

	public Long getCarId() {
		return carId;
	}

	public void setCarId(Long carId) {
		this.carId = carId;
	}

	public List <User> getUser() {
		return user;
	}

	public void setUser(List <User> user) {
		this.user = user;
	}
}