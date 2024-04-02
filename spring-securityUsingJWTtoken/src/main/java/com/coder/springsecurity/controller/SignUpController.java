package com.coder.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.springsecurity.dto.SignUpRequest;
import com.coder.springsecurity.entity.Customer;
import com.coder.springsecurity.service.AuthService;


@RestController
@RequestMapping("/signup")
@CrossOrigin("*")
public class SignUpController {
	
	@Autowired
	 private AuthService authService;
	

	@PostMapping("")
	 public ResponseEntity<?>  signUpCustomer(@RequestBody SignUpRequest signUpRequest){
		//String success="Customer created succesfully.";
		Customer Customer=authService.createCustomer(signUpRequest);
		 if(Customer!=null) {
			 return ResponseEntity.status(HttpStatus.CREATED).body(Customer);
		 }else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create customer.");
		}	
		 
	 }

}
