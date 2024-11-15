import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Car } from '../model/car';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  private baseUrl = 'http://localhost:8081/api/cars';

  constructor(private http : HttpClient) { }

  addCar(car: Car): Observable<Car> {
    return this.http.post<Car>(`${this.baseUrl}/addCar`, car);
  }

  findAll(): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.baseUrl}`);
  }

  getCarById(id: number): Observable<Car> {
    return this.http.get<Car>(`${this.baseUrl}/${id}`);
  }

  getCarsByDriverId(driverId: number): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.baseUrl}/driver/${driverId}`);
  }

  getCarsByCategory(category: string): Observable<Car[]> {
    return this.http.get<Car[]>(`${this.baseUrl}/category/${category}`);
  }

  deleteById(carNo: number): Observable<boolean> {
    return this.http.delete<boolean>(`${this.baseUrl}/${carNo}`);
  }

  updateCar(carNo: number, carDetails: Car): Observable<Car> {
    return this.http.put<Car>(`${this.baseUrl}/${carNo}`, carDetails);
  }
  
}
