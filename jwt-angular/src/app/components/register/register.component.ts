import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { JwtService } from '../../service/jwt.service';


@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css',
  providers:[JwtService]
  
  
})
export class RegisterComponent implements OnInit {

  constructor(
    private fb:FormBuilder,
    private service:JwtService
  ){}

  registerForm!: FormGroup;

  ngOnInit(): void {
   this.registerForm =this.fb.group({
    name:["",[Validators.required]],
    email:["",[Validators.required,Validators.email]],
    password:["",[Validators.required]],
    confirmPassword:["",[Validators.required]]
   },{validators: this.passwordMatchValidator })
  }
  passwordMatchValidator( formGroup:FormGroup){
    const password=formGroup.get('password')?.value;
    const confirmPassword=formGroup.get('confirmPassword')?.value;

    if(password!==confirmPassword){
      formGroup.get('confirmPassword')?.setErrors({passwordMismatch:true})
    }
    else{
      formGroup.get('confirmPassword')?.setErrors(null)
    }
  }

  submitForm(){
    console.log(this.registerForm?.value)
    this.service.register(this.registerForm?.value).subscribe((response)=>{
        if(response.id!=null){
        
           // Reset the form to its initial state
        this.registerForm.reset();

        // Display a success message
        alert(response.name+'- You Are registered succesfully.');
        }
      console.log(response)
    }
       )
  }

}
