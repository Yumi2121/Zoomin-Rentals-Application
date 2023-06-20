package com.rentals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rentals.dao.CustomerDao;
import com.rentals.model.Customer;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	@Qualifier(value = "custrepo")
	private CustomerDao dao;
	
	@Override
	public Customer save(Customer cust) {
		System.out.println("inside of CustomerServiceImp: save()");
		Customer c = dao.save(cust);
		return c;
	}

	@Override
	public List<Customer> retriveAllCustomers() {
		System.out.println("inside of CustomerServiceImp: retriveAllCustomers()");
		List<Customer> customers = dao.findAll();
		return customers;
	}

	@Override
	public Customer retriveOne(int id) {
		System.out.println("inside of CustomerServiceImp: retriveOne()");
		Optional<Customer> opt = dao.findById(id);
		Customer c;
		if(opt.isPresent()) {
			c = opt.get();
			return c;
		}
		
		return null;
	}

	@Override
	public void deleteOneCustomer(int id) {
		System.out.println("inside of CustomerServiceImp: deleteOneCustomer()");
		dao.deleteById(id);
	}

	@Override
	public List<Customer> findByName(String name) {
		System.out.println("inside of CustomerServiceImp: findByName()");
		return dao.findByName(name);
	}

	@Override
	public Customer findByEmail(String email) {
		System.out.println("Inside of CustomerServiceImp: ===============================");
		return dao.findByEmail(email);
	}

}
