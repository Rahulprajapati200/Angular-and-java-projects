package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.com.dto.CustomerDto;
import com.example.com.service.CustomerService;
import com.example.demo.entity.Customer;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerController {
	@Autowired
	 private CustomerService accountService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<CustomerDto> addAccount( @RequestBody CustomerDto accountsDto){
		return new ResponseEntity<>(accountService.createAccount(accountsDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers(){
		return accountService.getAllCustomers();
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public void deleteCustomers(@PathVariable Long id){
		 accountService.deleteCustomer(id);
	}
	
	@GetMapping("/getCustomerById/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customer=accountService.getCustomerById(id);
		if(customer==null) {
			return  ResponseEntity.notFound().build();			
		}
		return ResponseEntity.ok(customer);
		
	}
	
	@PutMapping("updateCustomer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,@RequestBody Customer customer){
		Customer updatedCustomer=accountService.updateCustomer(id, customer);
		if(updatedCustomer == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		else {
		return ResponseEntity.ok(updatedCustomer);
		}
		
	}
	 
	

}
