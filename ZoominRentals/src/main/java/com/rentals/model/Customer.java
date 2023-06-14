package com.rentals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "license")
	private int licenseno; 
	
	public Customer(int id, String name, String mobile, int licenseno) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.licenseno = licenseno;

	}
	
	public Customer(String name, String mobile, int licenseno) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.licenseno = licenseno;
	}
	
	public Customer() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getLicenseno() {
		return licenseno;
	}

	public void setLicenseno(int licenseno) {
		this.licenseno = licenseno;
	}


	@Override
	public String toString() {
		return "\nCustomer\nID: " + id + "\nName: " + name + "\nMobile: " + mobile + "\nLicense Number: " + licenseno;
	}
	
	
}
