package com.rentals.service;

import java.util.List;

import com.rentals.model.Booking;


public interface BookingService {
	public Booking save(Booking book);
	public List<Booking> retriveAllBookings();
	public Booking retriveOne(int id);
	public void deleteOneBooking(int id);
	//public List<Booking> findByName(String name);
}
