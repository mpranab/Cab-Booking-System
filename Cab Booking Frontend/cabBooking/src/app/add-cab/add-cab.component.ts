import { Component } from '@angular/core';
import { CarService } from '../services/car.service';
import { Car } from '../model/car';
import { CarCategory } from '../model/car-category.enum';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Driver } from '../model/driver';

@Component({
  selector: 'app-add-cab',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './add-cab.component.html',
  styleUrls: ['./add-cab.component.css']
})
export class AddCabComponent {
  newCar: Car = {
    carId: 0,
    carNumber: '',
    carCategory: CarCategory.SEDAN,
    rateHour: 0,
    available: true,
    driver: new Driver(), 
    driverId: 0,
    name: '',
    mobNumber: 0,
    licenseNo: ''
  };

  carCategories = Object.values(CarCategory); 

  constructor(private carService: CarService) {}

  addCab(): void {

    if (this.newCar.carNumber && this.newCar.rateHour) {
      this.carService.addCar(this.newCar).subscribe({
        next: (car) => {
          alert('Car added successfully!');
          this.resetForm(); 
        },
        error: (error) => console.error('Error adding car:', error),
      });
    } else {
      alert('Please fill out all required fields.');
    }
  }

  resetForm(): void {
    this.newCar = {
      carId: 0,
      carNumber: '',
      carCategory: CarCategory.SEDAN,
      rateHour: 0,
      available: true,
      driver: new Driver(), 
      driverId: 0,
      name: '',
      mobNumber: 0,
      licenseNo: ''
    };
  }
}