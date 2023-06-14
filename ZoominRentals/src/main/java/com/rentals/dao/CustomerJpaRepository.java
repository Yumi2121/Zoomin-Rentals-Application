package com.rentals.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentals.model.Customer;

@Repository(value = "custrepo")
public interface CustomerJpaRepository extends CustomerDao, JpaRepository<Customer, Integer> {

}
