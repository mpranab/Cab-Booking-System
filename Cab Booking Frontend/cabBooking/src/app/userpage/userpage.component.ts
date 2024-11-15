import { Component } from '@angular/core';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-userpage',
  standalone: true,
  imports: [],
  templateUrl: './userpage.component.html',
  styleUrl: './userpage.component.css'
})
export class UserpageComponent {

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



  addBooking() {
    this.router.navigate(['/addbooking']);
  }

  viewBooking() {
    this.router.navigate(['/userbooking']);
  }

}

