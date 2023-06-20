package com.rentals.dao;

import java.util.List;
import java.util.Optional;

import com.rentals.model.Customer;


public interface CustomerDao {
	
	public Customer save(Customer cust);
	
	public List<Customer> findAll();
	
	Optional<Customer> findById(int id);
	
	public Customer deleteById(int id);
	
	public List<Customer> findByName(String name);
	
	public Customer findByEmail(String email);
}
