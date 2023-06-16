package com.rentals.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Size(min=3,message="Name must have atleast 3 chars")
	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;
	@Column(name = "mobile")
	private String mobile;
	@Column(name = "license")
	private int licenseno; 
	@Column(name = "email")
	private String email;
	@Size(min=8,message="Password must contain atleast 8 characters")
	@NotBlank(message = "Name is mandatory")
	@Column(name = "password")
	private String password;
	
	public Customer(int id, String name, String mobile, int licenseno, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.licenseno = licenseno;
		this.email = email;
		this.password = password;

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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "\nCustomer\nID: " + id + "\nName: " + name + "\nMobile: " + mobile + "\nLicense Number: " + licenseno + "\nEmail: " + email + "\nPassword: " + password;
	}
	
	
}
