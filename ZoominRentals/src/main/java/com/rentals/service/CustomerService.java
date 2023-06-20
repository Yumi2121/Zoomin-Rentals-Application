package com.rentals.service;

import java.util.List;

import com.rentals.model.Customer;

public interface CustomerService {
	public Customer save(Customer cust);
	public List<Customer> retriveAllCustomers();
	public Customer retriveOne(int id);
	public void deleteOneCustomer(int id);
	public List<Customer> findByName(String name);
	public Customer findByEmail(String email);
}
