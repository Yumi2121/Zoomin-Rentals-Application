package com.rentals.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rentals.dao.BookingDao;
import com.rentals.model.Booking;

@Service
public class BookingServiceImp implements BookingService {

	@Autowired
	@Qualifier(value = "bookingrepo")
	private BookingDao dao;
	
	@Override
	public Booking save(Booking book) {
		System.out.println("inside of BookingServiceImp: save()");
		Booking b = dao.save(book);
		return b;
	}

	@Override
	public List<Booking> retriveAllBookings() {
		System.out.println("inside of BookingServiceImp: retriveAllBookings()");
		List<Booking> books = dao.findAll();
		return books;
	}

	@Override
	public Booking retriveOne(int id) {
		System.out.println("inside of BookingServiceImp: retriveOne()");
		Optional<Booking> opt = dao.findById(id);
		Booking b;
		if(opt.isPresent()) {
			b = opt.get();
			return b;
		}
		return null;
	}

	@Override
	public void deleteOneBooking(int id) {
		System.out.println("inside of BookingServiceImp: save()");
		dao.deleteById(id);
	}

	/*
	 * @Override public List<Booking> findByName(String name) {
	 * System.out.println("inside of BookingServiceImp: save()"); return
	 * dao.findByName(name); }
	 */

}
