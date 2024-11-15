import { Routes } from '@angular/router';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { AdminComponent } from './admin/admin.component';
import { AllBookingsComponent } from './all-bookings/all-bookings.component';
import { AddBookingComponent } from './add-booking/add-booking.component';
import { AllCabsComponent } from './all-cabs/all-cabs.component';
import { AddCabComponent } from './add-cab/add-cab.component';
import { UserpageComponent } from './userpage/userpage.component';
import { UserBookingComponent } from './user-booking/user-booking.component';

export const routes: Routes = [

    {path: '', redirectTo: 'home', pathMatch: 'full' },
    {path:"home",component:HomeComponent},
    {path:"contactUs",component:ContactUsComponent},
    {path:"aboutUs",component:AboutUsComponent},
    {path:"signUp",component:RegisterComponent},
    {path:"login",component:LoginComponent},
    {path:"admin",component:AdminComponent},
    {path:"allbookings",component:AllBookingsComponent},
    {path:"addbooking",component:AddBookingComponent},
    {path:"allcabs",component:AllCabsComponent},
    {path:"addcab",component:AddCabComponent},
    {path:"userpage",component:UserpageComponent},
    {path:"userbooking",component:UserBookingComponent}
];
