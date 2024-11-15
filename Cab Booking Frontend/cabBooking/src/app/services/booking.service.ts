import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from '../model/booking';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  private baseUrl = 'http://localhost:8083/bookings';

  constructor(private http: HttpClient) { }

  addBooking(booking: Booking): Observable<Booking> {
    return this.http.post<Booking>(`${this.baseUrl}/addBooking`, booking);
  }

  getBookingById(id: number): Observable<Booking> {
    return this.http.get<Booking>(`${this.baseUrl}/${id}`);
  }
//putmapping
  endRide(id: number): Observable<void> {
    return this.http.put<void>(`${this.baseUrl}/${id}/end-ride`, {});
  }

  getAllBookings(): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.baseUrl}`);
  }

  getBookingsByPickupDrop(pickupPoint: string, dropPoint: string): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.baseUrl}/search/${pickupPoint}/${dropPoint}`);
  }

  getBookingsBetweenTimes(startTime: string, endTime: string): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.baseUrl}/time/${startTime}/${endTime}`);
  }

  getAllBookingsByCarId(carId: number): Observable<Booking[]> {
    return this.http.get<Booking[]>(`${this.baseUrl}/car/${carId}`);
  }

  getBookingsByFirstNameAndLastName(firstName: string, lastName: string): Observable<Booking[]> {
    const params = new HttpParams()
      .set('firstName', firstName)
      .set('lastName', lastName);

    return this.http.get<Booking[]>(`${this.baseUrl}/user`, { params });
  }
}
