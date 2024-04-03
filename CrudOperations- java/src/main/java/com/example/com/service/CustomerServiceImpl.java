package com.example.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.com.dto.CustomerDto;
import com.example.com.dto.ClassMapper;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;	
	

	@Override
	public CustomerDto createAccount(CustomerDto accountsDto) {
		return ClassMapper.customerToCustomerDto(customerRepository.save(ClassMapper.customerDtoToCustomer(accountsDto)));
	}
	
	@Override
	public List<Customer> getAllCustomers(){		
		return customerRepository.findAll();
		
	}
	@Override
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
	
	
	@Override
	public Customer getCustomerById(Long id) {
		
		return customerRepository.findById(id).get();
			
	}
	@Override
	public Customer updateCustomer(Long id,Customer updatedCustomer) {
		
		return  customerRepository.findById(id)
				.map(customer->{
					customer.setEmail(updatedCustomer.getEmail());
					customer.setName(updatedCustomer.getName());
					customer.setPhone(updatedCustomer.getPhone());
			return customerRepository.save(customer); 
		}).orElse(null);
		
		
	}

}
