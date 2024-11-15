import { User } from "./user";

export class Booking {
    bookingId: number = 0;
    pickupPoint: string = '';
    dropPoint: string = '';
    pickupDate: Date=new Date() ;  
    pickupTime: string ='';  
    dropDate: Date=new Date();
    dropTime: string='';  
    carId: number=0;
    user: User[]=[];



    userId: number = 0;
    firstName: string = '';
    lastName: string = '';
    phoneNumber: number = 0;
    email: string = '';
}