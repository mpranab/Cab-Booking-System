import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Car } from '../model/car';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-all-cabs',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './all-cabs.component.html',
  styleUrl: './all-cabs.component.css'
})
export class AllCabsComponent implements OnInit {
  cars: Car[] = [];

  constructor(private carService: CarService) {}

  ngOnInit(): void {
    this.getAllCars();
  }

  getAllCars(): void {
    this.carService.findAll().subscribe({
      next: (data) => this.cars = data,
      error: (error) => console.error('Error fetching car data:', error)
    });
  }
}
