import { Component, OnInit } from '@angular/core';
import { JwtService } from '../../service/jwt.service';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
  providers:[JwtService]
})
export class LoginComponent implements OnInit {

  loginForm!: FormGroup;

  constructor(
    private service:JwtService,
    private fb:FormBuilder,
    private router:Router
  ){}

  ngOnInit(): void {
    this.loginForm=this.fb.group({
      email: ["",[Validators.required,Validators.email]],
      password: ["",Validators.required]
    })
  }
  submitForm(){
    this.service.login(this.loginForm.value).subscribe((response)=>{
      if(response.jwtToken!=null)
      {
        alert("Hello, Your token is -"+response.jwtToken)
        const jwtToken=response.jwtToken;
        localStorage.setItem("jwtToken",jwtToken);
        this.router.navigateByUrl("/dashboard");
      }
     
    })
   
  }

}
