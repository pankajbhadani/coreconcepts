package com.bittu.coreconcepts.serialization.basicCode;

import java.io.Serializable;

public class Address implements Serializable {
	private int houseNumber;
	private String address;
	private String landmark;
	private String city;
	
	public int getHouseNumber() {
		return houseNumber;
	}
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [houseNumber=" + houseNumber + ", address=" + address + ", landmark=" + landmark + ", city="
				+ city + "]";
	}
}
