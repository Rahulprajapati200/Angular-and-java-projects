package com.coder.springsecurity.service.jwt;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.coder.springsecurity.entity.Customer;
import com.coder.springsecurity.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// write logic to fetch customer from DB.
		
			Customer customer= customerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Customer not found with email."+email));
		
		
		return new User(customer.getEmail(), customer.getPassword(), Collections.emptyList());
	}

}
