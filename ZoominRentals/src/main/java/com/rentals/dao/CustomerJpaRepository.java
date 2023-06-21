package com.rentals.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rentals.model.Customer;

@Repository(value = "custrepo")
public interface CustomerJpaRepository extends CustomerDao, JpaRepository<Customer, Integer> {
	@Query(value = "SELECT * FROM customer WHERE email = ?1", nativeQuery = true)
	public Customer findByEmail(String email);

}
