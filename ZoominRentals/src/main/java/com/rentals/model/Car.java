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
	
	public Car(int id, String brand, String model, String rego, boolean rented) {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.name = rego;
		this.rented = rented;
	} 
	
	public Car( String brand, String model, String rego, boolean rented) {
		super();
		this.brand = brand;
		this.model = model;
		this.name = rego;
		this.rented = rented;
	} 
	
	public Car() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}
	
	
	public String getRego() {
		return name;
	}

	public void setRego(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "\nCar\nID: " + id + "\nBrand: " + brand + "\nModel: " + model + "\nRego: " + name + "\nAvailable? " + rented;
	}
	
	
}
