package com.rentals.service;

import java.util.List;

import com.rentals.model.Car;

public interface CarService {
	public Car save(Car c);
	public List<Car> retriveAllCars();
	public Car retriveOne(int id);
	public void deleteOneCar(int id);
	public List<Car> findByRego(String rego);
}
