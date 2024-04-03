package com.example.com.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
	
	private long id;	
	private String name;	
	private String email;
	private String phone;
}
