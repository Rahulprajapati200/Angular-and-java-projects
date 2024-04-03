import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CustomerService } from '../../service/customer.service';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-update-customer',
  standalone: true,
  imports: [RouterModule,ReactiveFormsModule,FormsModule],
  providers:[CustomerService],
  templateUrl: './update-customer.component.html',
  styleUrl: './update-customer.component.css'
})
export class UpdateCustomerComponent {

  id:number = this.activatedRoute.snapshot.params[`id`]
  updateCustomerForm!: FormGroup;
  constructor(private activatedRoute: ActivatedRoute,
    private service:CustomerService,
    private fb:FormBuilder,
    private router:Router){}

    ngOnInit(){
      this.updateCustomerForm=this.fb.group({
        name:[null,Validators.required],
        email:[null,[Validators.required,Validators.email]],
        phone:[null,Validators.required]
      });
      this.getCustomerById();
    }

    getCustomerById(){
      this.service.getCustomerById(this.id).subscribe((res)=>{
       console.log(res); 
       this.updateCustomerForm.patchValue(res);
      })
    }

    updateCustomer(){
      this.service.updateCustomer(this.id,this.updateCustomerForm.value).subscribe((res)=>{
       console.log(res); 
       this.router.navigateByUrl("");
      })
    }

    


}
