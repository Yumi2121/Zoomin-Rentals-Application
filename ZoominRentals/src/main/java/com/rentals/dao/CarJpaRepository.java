package com.rentals.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentals.model.Car;

@Repository(value = "carrepo")
public interface CarJpaRepository extends CarDao, JpaRepository<Car, Integer> {

}
