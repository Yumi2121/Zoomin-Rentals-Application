package com.rentals.dao;

import java.util.List;
import java.util.Optional;

import com.rentals.model.Car;


public interface CarDao {
	
	public Car save(Car c);
	
	public List<Car> findAll();
	
	Optional<Car> findById(int id);
	
	public Car deleteById(int id);
	
	public List<Car> findByName(String name);
	
	public List<Car> findBySeats(int seats);
}
