package com.coder.springsecurity.service;

import com.coder.springsecurity.dto.SignUpRequest;
import com.coder.springsecurity.entity.Customer;

public interface AuthService {

	Customer createCustomer(SignUpRequest signUpRequest);

}
