package com.kidfriendlystl;

public class Business {

	private int id;				// *required
	private String name;		// *required
	private String address;	
	private String city;		// *required
	private String state;		// *required
	private String zip;
	private String phone;
	private String website;
	private int rating;			// *required
	
	private int rating1;
	private int rating2;
	private int rating3;
	private int rating4;
	private int rating5;
	
	public Business(int id, String name, String address, String city, String state, String zip,
			String phone, String website, int rating1, int rating2, int rating3, int rating4, int rating5) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.website = website;
		this.rating1 = rating1;
		this.rating2 = rating2;
		this.rating3 = rating3;
		this.rating4 = rating4;
		this.rating5 = rating5;
		
		this.rating = (rating1*1 + rating2*2 + rating3*3 + rating4*4 +rating5*5) / (rating1+rating2+rating3+rating4+rating5);
	}

	public Business(String name, String address, String city, String state, String zip,
			String phone, String website, int rating1, int rating2, int rating3, int rating4, int rating5) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
		this.website = website;
		this.rating1 = rating1;
		this.rating2 = rating2;
		this.rating3 = rating3;
		this.rating4 = rating4;
		this.rating5 = rating5;
		
		this.rating = (rating1*1 + rating2*2 + rating3*3 + rating4*4 +rating5*5) / (rating1+rating2+rating3+rating4+rating5);
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

	public int getRating() {
		return rating;
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
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRating1() {
		return rating1;
	}

	public void setRating1(int rating1) {
		this.rating1 = rating1;
	}

	public int getRating2() {
		return rating2;
	}

	public void setRating2(int rating2) {
		this.rating2 = rating2;
	}

	public int getRating3() {
		return rating3;
	}

	public void setRating3(int rating3) {
		this.rating3 = rating3;
	}

	public int getRating4() {
		return rating4;
	}

	public void setRating4(int rating4) {
		this.rating4 = rating4;
	}

	public int getRating5() {
		return rating5;
	}

	public void setRating5(int rating5) {
		this.rating5 = rating5;
	}	
	
}
