import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const BASE_URL="http://localhost:8080/"
@Injectable({
  providedIn: 'root'
})
export class JwtService {

  constructor(private http:HttpClient) { }

  register(signRequest:any): Observable<any>{
    return this.http.post(BASE_URL+'signup',signRequest);
  }

  login(loginRequest:any): Observable<any>{
    return this.http.post(BASE_URL+'login',loginRequest);
  }

  hello(): Observable<any>{
    return this.http.get(BASE_URL+'api/hello',{
      headers:this.createAutherizationHeader()});
  }
  private createAutherizationHeader(){
    const jwtToken=localStorage.getItem("jwtToken");
    if(jwtToken!=null){
      console.log("jwtToken found in local storage",jwtToken)
      return new HttpHeaders().set(
        "Authorization","Bearer "+jwtToken
        )
    }
    else{
      console.log("jwtToken not found in local storage.")
      return new HttpHeaders();
    }
    
  }
}
