package com.example.com.dto;

import com.example.demo.entity.Customer;

public class ClassMapper {
	
	public static Customer customerDtoToCustomer(CustomerDto customerDto) {
		Customer customer=new Customer(customerDto.getId(),customerDto.getName(),customerDto.getEmail(),customerDto.getPhone());
		return customer;
		
	}
	
	public static CustomerDto customerToCustomerDto(Customer customer) {
		CustomerDto customerDto=new CustomerDto(customer.getId(),customer.getName(),customer.getEmail(),customer.getPhone());
		return customerDto;
		
	}

}
