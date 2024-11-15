import { CarCategory } from "./car-category.enum";
import { Driver } from "./driver";

export class Car {

    carId: number=0;
    carNumber: string='';
    carCategory: CarCategory = CarCategory.SEDAN;
    rateHour: number=0;
    available: boolean = true;
    driver: Driver = new Driver();


    driverId: number = 0;
    name: string = '';
    mobNumber: number = 0;
    licenseNo: string = '';
  
}