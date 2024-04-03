import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PostCustomerComponent } from './components/post-customer/post-customer.component';
import { HttpClientModule } from '@angular/common/http';
import { CustomerService } from './service/customer.service';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,HttpClientModule,FormsModule,ReactiveFormsModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'y';
}
