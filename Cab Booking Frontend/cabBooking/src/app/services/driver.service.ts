import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Driver } from '../model/driver';

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  private baseUrl = 'http://localhost:8082/drivers';

  constructor(private http: HttpClient) { }

  addDriver(driver: Driver): Observable<Driver> {
    return this.http.post<Driver>(`${this.baseUrl}/addDriver`, driver);
  }

  getDriverById(id: number): Observable<Driver> {
    return this.http.get<Driver>(`${this.baseUrl}/${id}`);
  }

  getAllDrivers(): Observable<Driver[]> {
    return this.http.get<Driver[]>(`${this.baseUrl}`);
  }

  deleteDriverById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  updateDriver(id: number, driver: Driver): Observable<Driver> {
    return this.http.put<Driver>(`${this.baseUrl}/${id}`, driver);
  }
}
