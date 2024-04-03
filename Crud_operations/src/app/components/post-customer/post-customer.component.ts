import { Component,OnInit } from '@angular/core';
import { CustomerService } from '../../service/customer.service';
import { HttpClientModule } from '@angular/common/http';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-customer',
  standalone: true,
  imports: [HttpClientModule,ReactiveFormsModule,FormsModule],
  providers:[CustomerService],
  templateUrl: './post-customer.component.html',
  styleUrl: './post-customer.component.css'
})
export class PostCustomerComponent implements OnInit {

  postCustomerForm!: FormGroup;

   constructor(private customerService:CustomerService,
    private fb: FormBuilder,
    private router:Router){

   }
   
   ngOnInit():void{
    this.postCustomerForm=this.fb.group({
      name:[null,Validators.required],
      email:[null,[Validators.required,Validators.email]],
      phone:[null,Validators.required]
    });
   }

   postCustomer(){
       this.customerService.postCustomer(this.postCustomerForm.value).subscribe((res)=>{
      console.log(res);
      this.router.navigateByUrl("getAllCustomers");
         })
  
   }

}
