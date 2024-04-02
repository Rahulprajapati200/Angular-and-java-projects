package com.coder.springsecurity.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.coder.springsecurity.dto.SignUpRequest;
import com.coder.springsecurity.entity.Customer;
import com.coder.springsecurity.repository.CustomerRepository;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private  PasswordEncoder passwordEncoder;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer createCustomer(SignUpRequest signUpRequest) {
		
		//check if customer already exist.
		if(customerRepository.existsByEmail(signUpRequest.getEmail())) {
			return null;
		}
		
		Customer customer= new Customer();
		BeanUtils.copyProperties(signUpRequest, customer);
		
		//Hash The Password before saving.
		 String hashPassword=passwordEncoder.encode(signUpRequest.getPassword());
		 customer.setPassword(hashPassword);
		 return customerRepository.save(customer);		
		
	}
	

}
