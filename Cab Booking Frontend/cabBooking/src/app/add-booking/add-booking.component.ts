import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Booking } from '../model/booking';
import { BookingService } from '../services/booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../model/user';

@Component({
  selector: 'app-add-booking',
  standalone: true,
  imports: [FormsModule,CommonModule,ReactiveFormsModule],
  templateUrl: './add-booking.component.html',
  styleUrl: './add-booking.component.css'
})
export class AddBookingComponent {
  booking: Booking = new Booking();
  successMessage: string = '';
  errorMessage: string = '';

  constructor(private bookingService: BookingService) {
    this.booking.user.push(new User()); 
  }

  addBooking() {
    this.bookingService.addBooking(this.booking).subscribe({
      next: () => {
        this.successMessage = 'Booking added successfully!';
        this.errorMessage = '';
        this.resetForm();
        alert(this.successMessage); 
      },
      error: (error) => {
        this.errorMessage = 'Failed to add booking. Please try again.';
        this.successMessage = '';
        console.error('Error:', error);
        alert(this.errorMessage);
      }
    });
  }

  addUser() {
    this.booking.user.push(new User()); 
  }

  resetForm() {
    this.booking = new Booking();
    this.booking.user.push(new User()); 
  }
}