import { Component, OnInit } from '@angular/core';
import { Booking } from '../model/booking';
import { BookingService } from '../services/booking.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-booking',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './user-booking.component.html',
  styleUrl: './user-booking.component.css'
})
export class UserBookingComponent implements OnInit {
  
  bookings: Booking[] = [];  
  firstName: string = '';     
  lastName: string = '';     
  errorMessage: string = '';  

  constructor(private bookingService: BookingService) {}

  ngOnInit(): void {
    
  }


  getBookings(): void {
    
    this.errorMessage = '';

    if (this.firstName && this.lastName) {
      this.bookingService.getBookingsByFirstNameAndLastName(this.firstName, this.lastName).subscribe(
        (data) => {
          this.bookings = data;  
        },
        (error) => {
          console.error('Error fetching bookings', error);
          this.errorMessage = 'Failed to fetch bookings for the provided user.';
        }
      );
    } else {
      this.errorMessage = 'Please provide both first name and last name.';
    }
  }
}
