package com.rentals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rentals.dao.CarDao;
import com.rentals.model.Car;

@Service
public class CarServiceImp implements CarService {

	@Autowired
	@Qualifier(value = "carrepo")
	private CarDao dao;
	
	@Override
	public Car save(Car c) {
		System.out.println("inside of CarServiceImp: save()");
		Car car = dao.save(c);
		return car;
	}

	@Override
	public List<Car> retriveAllCars() {
		System.out.println("inside of CarServiceImp: findByRego()");
		List<Car> cars = dao.findAll();
		return cars;
	}

	@Override
	public Car retriveOne(int id) {
		System.out.println("inside of CarServiceImp: findByRego()");
		Optional<Car> opt = dao.findById(id);
		Car c;
		if(opt.isPresent()) {
			c = opt.get();
			return c;
		}
		return null;
	}

	@Override
	public void deleteOneCar(int id) {
		System.out.println("inside of CarServiceImp: findByRego()");
		dao.deleteById(id);
	}

	@Override
	public List<Car> findByRego(String rego) {
		System.out.println("inside of CarServiceImp: findByRego()");
		return dao.findByName(rego);
	}

	@Override
	public List<Car> findBySeats(int seats) {
		System.out.println("inside of CarServiceImp: findBySeats()");
		return dao.findBySeats(seats);
	}

}
