package com.coder.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coder.springsecurity.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{

	boolean existsByEmail(String email);

	Optional<Customer> findByEmail(String email);

}
