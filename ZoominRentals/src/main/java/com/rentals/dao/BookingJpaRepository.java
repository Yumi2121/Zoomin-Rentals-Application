package com.rentals.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentals.model.Booking;

@Repository(value = "bookingrepo")
public interface BookingJpaRepository extends BookingDao, JpaRepository<Booking, Integer> {

}
