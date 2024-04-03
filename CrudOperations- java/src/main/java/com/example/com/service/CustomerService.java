package com.example.com.service;

import java.util.List;

import com.example.com.dto.CustomerDto;
import com.example.demo.entity.Customer;

public interface CustomerService {
	
	public CustomerDto createAccount(CustomerDto accountsDto);

	public List<Customer> getAllCustomers();

	void deleteCustomer(Long id);

	public Customer getCustomerById(Long id);

	public Customer updateCustomer(Long id, Customer updatedCustomer);

}
