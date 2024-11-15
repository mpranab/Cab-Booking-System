import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  url="http://localhost:8900/auth/api"
  constructor(private http:HttpClient) { }
 
  public registerUser(signup:any){
    return this.http.post(`${this.url}/signup`,signup);
  }
 
  public authenticateUser(loginRequest:any){
    return this.http.post(`${this.url}/signin`,loginRequest);

    
  }

}
