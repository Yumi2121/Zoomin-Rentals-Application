package com.rentals.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rentals.model.Customer;
import com.rentals.service.CustomerService;

@RestController
@CrossOrigin(origins = "*")
public class CustomerResource {

	@Autowired
	private CustomerService service;
	
	@GetMapping(path = "/customers")
	public @ResponseBody List<Customer> fetchAllCustomers(){	
		System.out.println("Inside fetchAllCustomers() of CustomerService");
		List<Customer> list = service.retriveAllCustomers();
		return list;
	}
	
	@GetMapping(path = "/customers/{id}", consumes = "application/json")
	public Customer fetchCustomer(@PathVariable int id) {
		System.out.println("Inside fetchCustomer() of CustomerService");
		Customer c = service.retriveOne(id);
		if(c == null) {
			//throw new StudentNotFoundException("user with id: " + id + " not found");
		}
		return c;
	}
	
	@PostMapping(path="/customers",consumes = "application/json")
	public Customer createCustomer(@Validated @RequestBody Customer Customer) {
		System.out.println("Inside createCustomer of CustomerService");
		Customer c = service.save(Customer);
		
		return c;
	}

	@DeleteMapping(path = "/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		System.out.println("Inside deleteCustomer of CustomerService");
		service.deleteOneCustomer(id);
	}
	
	@GetMapping(path = "/customers/name/{name}")
	public List<Customer> retrieveCustomersByName(@PathVariable String rego) {
		System.out.println("Inside retrieveCustomersByName of CustomerService");
		List<Customer> customers = service.findByName(rego);
		System.out.println("Returned Customers: " + customers);
		
		if(customers == null) {
			//throw new StudentNotFoundException("no users found with name: '" + rego + "'");
		}
		
		return customers;
	}
	
	@GetMapping(path = "/customers/email/{email}/{pass}")
	public Customer retrieveCustomerByEmail(@PathVariable String email, @PathVariable String pass) {
		System.out.println("Inside retrieveCustomerByEmail of CustomerService");
		Customer c = service.findByEmail(email);
		System.out.println(email + " " + pass);
		System.out.println(c);
		if (c.getPassword().equals(pass)) {
			System.out.println("login successful");
			return c;
		}
		
		return null;
	}
}
