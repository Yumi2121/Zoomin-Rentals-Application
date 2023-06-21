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

import com.rentals.model.Car;
import com.rentals.service.CarService;

@RestController
@CrossOrigin(origins = "*")
public class CarResource {
	
	@Autowired
	private CarService service;
	
	@GetMapping(path = "/cars")
	public @ResponseBody List<Car> fetchAllCars(){	
		System.out.println("Inside fetchAllCars() of CarService");
		List<Car> list = service.retriveAllCars();
		return list;
	}
	
	@GetMapping(path = "/cars/{id}", consumes = "application/json")
	public Car fetchCar(@PathVariable int id) {
		System.out.println("Inside fetchCar() of CarService");
		Car s = service.retriveOne(id);
		if(s == null) {
			//throw new StudentNotFoundException("user with id: " + id + " not found");
		}
		return s;
	}
	
	@PostMapping(path="/cars",consumes = "application/json")
	public Car createCar(@Validated @RequestBody Car car) {
		System.out.println("Inside createCar of CarService");
		Car c = service.save(car);
		
		return c;
	}

	
	@DeleteMapping(path = "/cars/{id}")
	public void deleteCar(@PathVariable int id) {
		System.out.println("Inside deleteCar of CarService");
		service.deleteOneCar(id);
	}
	
	@GetMapping(path = "/cars/name/{name}")
	public List<Car> retrieveCarsByRego(@PathVariable String rego) {
		System.out.println("Inside retrieveUsersByName of CarService");
		List<Car> cars = service.findByRego(rego);
		System.out.println("Returned Cars: " + cars);
		
		if(cars == null) {
			//throw new StudentNotFoundException("no users found with name: '" + rego + "'");
		}
		
		return cars;
	}
	
	@GetMapping(path = "/cars/seats/{seats}")
	public List<Car> fetchCarBySeats(@PathVariable int seats) {
		System.out.println("Inside fetchCarBySeats() of CarService");
		List<Car> cars = service.findBySeats(seats);
		if(cars == null) {
			//throw new StudentNotFoundException("user with id: " + id + " not found");
		}
		return cars;
	}
	

}
