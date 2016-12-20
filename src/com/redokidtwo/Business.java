package com.redokidtwo;

public class Business {

	private int id;				// *required
	private String name;		// *required
	private String address;	
	private String city;		// *required
	private String state;		// *required
	private String zip;
	private String phone;
	private String website;
	
	public Business(int id, String name, String address, String city, String state, String zip,
			String phone, String website) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.website = website;
	}

	public Business(String name, String address, String city, String state, String zip,
			String phone, String website) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getPhone() {
		return phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setWebsite(String website) {
		this.website = website;
	}	
	
}
