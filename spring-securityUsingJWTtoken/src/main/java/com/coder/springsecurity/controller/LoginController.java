package com.coder.springsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.springsecurity.dto.LoginRequest;
import com.coder.springsecurity.dto.LoginResponse;
import com.coder.springsecurity.service.jwt.CustomerServiceImpl;
import com.coder.springsecurity.utils.JwtUtil;

@RestController
@RequestMapping("/login")
@CrossOrigin("*")
public class LoginController {
	
	@Autowired
	private  AuthenticationManager authenticationManager;
	@Autowired
	private CustomerServiceImpl  customerServiceImpl;
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@PostMapping("")
	public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
		
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		UserDetails userDetails;
	
		try {
			userDetails=customerServiceImpl.loadUserByUsername(loginRequest.getEmail());
		} catch (UsernameNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		String jwtToken=jwtUtil.generateToken(userDetails);
		
		//Additional logic can be added here if required.
				
		return ResponseEntity.ok(new LoginResponse(jwtToken));
		
	}

}
