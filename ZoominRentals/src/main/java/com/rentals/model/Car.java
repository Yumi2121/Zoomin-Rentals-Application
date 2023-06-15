package com.rentals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "year")
	private int year;
	@Column(name = "brand")
	private String brand;
	@Column(name = "model")
	private String model;
	@Column(name = "seats")
	private int seats;
	@Column(name = "transmission")
	private String transmission;
	@Column(name = "fuel")
	private String fuel;
	@Column(name = "rego")
	private String name;
	@Column(name = "isAvailable")
	private boolean rented;
	@Column(name = "price")
	private int price;
	
	public Car(int id, String brand, String model, String rego, boolean rented, int price) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.name = rego;
		this.rented = rented;
		this.price = price;
	} 
	
	public Car( String brand, String model, String rego, boolean rented, int price) {
		super();
		this.brand = brand;
		this.model = model;
		this.name = rego;
		this.rented = rented;
		this.price = price;
	} 
	
	public Car() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "\nCar\nID: " + id + "\nBrand: " + brand + "\nModel: " + model + "\nRego: " + name + "\nAvailable? " + rented + "\nPrice: $" + price;
	}
	
	
}
