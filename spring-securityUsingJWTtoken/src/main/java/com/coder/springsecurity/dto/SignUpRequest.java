package com.coder.springsecurity.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class SignUpRequest {
	
	private String name;
	private String password;
	private String email;
	

}
