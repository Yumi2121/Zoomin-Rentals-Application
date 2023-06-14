package com.rentals.dao;

import java.util.List;
import java.util.Optional;

import com.rentals.model.Booking;


public interface BookingDao {
	
	public Booking save(Booking book);
	
	public List<Booking> findAll();
	
	Optional<Booking> findById(int id);
	
	public Booking deleteById(int id);
	
	//public List<Booking> findByName(String name);
}
