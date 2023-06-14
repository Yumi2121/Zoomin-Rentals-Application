package com.rentals.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name = "custid")
	private int custid;
	@Column(name = "carid")
	private int carid;
	@Column(name = "pickupdate")
 	private LocalDate pickupdate;
	@Column(name = "returndate")
 	private LocalDate returndate;
 	
 	
	public Booking(int custid,  int carid, LocalDate pickupdate, LocalDate returndate) {
		super();
		this.custid = custid;
		this.carid = carid;
		this.pickupdate = pickupdate;
		this.returndate = returndate;	
	}
	
	public Booking() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public int getCarid() {
		return carid;
	}

	public void setCarid(int carid) {
		this.carid = carid;
	}

	public LocalDate getPickupdate() {
		return pickupdate;
	}

	public void setPickupdate(LocalDate pickupdate) {
		this.pickupdate = pickupdate;
	}

	public LocalDate getReturndate() {
		return returndate;
	}

	public void setReturndate(LocalDate returndate) {
		this.returndate = returndate;
	}

	@Override
	public String toString() {
		return "\nBooking\nId: " + id + "\nCustomer ID: " + custid + "\nCar ID: " + carid + "\nPickup Date:" + pickupdate
				+ "\nReturn Date: " + returndate;
	}
	
}
