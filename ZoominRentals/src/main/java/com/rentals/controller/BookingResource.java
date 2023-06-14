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

import com.rentals.model.Booking;
import com.rentals.service.BookingService;

@RestController
@CrossOrigin(origins = "*")
public class BookingResource {

	@Autowired
	private BookingService service;
	
	@GetMapping(path = "/bookings")
	public @ResponseBody List<Booking> fetchAllBookings(){	
		System.out.println("Inside fetchAllBookings() of BookingService");
		List<Booking> list = service.retriveAllBookings();
		return list;
	}
	
	@GetMapping(path = "/bookings/{id}", consumes = "application/json")
	public Booking fetchBooking(@PathVariable int id) {
		System.out.println("Inside fetchBooking() of BookingService");
		Booking b = service.retriveOne(id);
		if(b == null) {
			//throw new StudentNotFoundException("user with id: " + id + " not found");
		}
		return b;
	}
	
	@PostMapping(path="/bookings",consumes = "application/json")
	public Booking createBooking(@Validated @RequestBody Booking Booking) {
		System.out.println("Inside createBooking of BookingService");
		Booking b = service.save(Booking);
		
		return b;
	}

	
	@DeleteMapping(path = "/bookings/{id}")
	public void deleteBooking(@PathVariable int id) {
		System.out.println("Inside deleteBooking of BookingService");
		service.deleteOneBooking(id);
	}
	
	/*
	 * @GetMapping(path = "/bookings/name/{name}") public List<Booking>
	 * retrieveBookingsByRego(@PathVariable String name) {
	 * System.out.println("Inside retrieveUsersByName of BookingService");
	 * List<Booking> bookings = service.findByName(name);
	 * System.out.println("Returned Bookings: " + bookings);
	 * 
	 * if(bookings == null) { //throw new
	 * StudentNotFoundException("no users found with name: '" + rego + "'"); }
	 * 
	 * return bookings; }
	 */
}
