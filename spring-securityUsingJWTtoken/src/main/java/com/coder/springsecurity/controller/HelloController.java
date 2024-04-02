package com.coder.springsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coder.springsecurity.dto.HelloResponse;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class HelloController {
	
	@GetMapping("/hello")
	public ResponseEntity<HelloResponse> hello() {
		return ResponseEntity.status(HttpStatus.OK).body( new HelloResponse("Hello, You are succesfully login."));
	}

}
