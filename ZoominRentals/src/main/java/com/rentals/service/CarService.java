package com.rentals.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.rentals.model.Car;

public interface CarService {
	public Car save(Car c);
	public List<Car> retriveAllCars();
	public Car retriveOne(int id);
	public void deleteOneCar(int id);
	public List<Car> findByRego(String rego);
	public List<Car> findBySeats(int seats);
}
