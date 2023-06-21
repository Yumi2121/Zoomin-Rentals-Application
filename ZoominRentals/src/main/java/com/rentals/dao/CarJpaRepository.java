package com.rentals.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rentals.model.Car;

@Repository(value = "carrepo")
public interface CarJpaRepository extends CarDao, JpaRepository<Car, Integer> {
	
	@Query(value = "SELECT * FROM car WHERE seats = ?1", nativeQuery = true)
	public List<Car> findBySeats(int seats);
}
