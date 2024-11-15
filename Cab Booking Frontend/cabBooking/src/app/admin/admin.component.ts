import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.css'
})
export class AdminComponent {
  constructor(private router:Router) { }
  username:string | null="";
  ngOnInit(): void {
    if (typeof window !== 'undefined') {
      this.username = localStorage.getItem("username");
    }
  }

  logout()
  {
      
      Swal.fire({
        title: 'Logout',
        text: 'Are you sure you want to log out?',
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, logout'
      }).then((result) => {
        if (result.isConfirmed) {
          localStorage.removeItem('username');
      sessionStorage.removeItem('token');
          this.router.navigate(['/login']);
          Swal.fire(
            'Logged out!',
            'You have been logged out successfully.',
            'success'
          );
        }
      });
  }

  addCab() {
    this.router.navigate(['/addcab']);
  }

  allCabs() {
    this.router.navigate(['/allcabs']);
  }

  addBooking() {
    this.router.navigate(['/addbooking']);
  }
  bookings() {
    this.router.navigate(['/allbookings']);
  }
}
