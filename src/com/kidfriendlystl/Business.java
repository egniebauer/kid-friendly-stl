package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

public class Business {
		
	private int id;				// *required
	private String name;		// *required
	private String address;		// *required
	private String city;		// *required
	private State state;		// *required
	private String zip;
	private String phone;
	private String website;
	private int rating;
	
	private int rating1;
	private int rating2;
	private int rating3;
	private int rating4;
	private int rating5;
	
	public Business(int id, String name, String address, String city, State state, String zip,
			String phone, String website, int rating1, int rating2, int rating3, int rating4, int rating5) {
		this(name, address, city, state, zip, phone, website, rating1, rating2, rating3, rating4, rating5);
		this.id = id;
	}

	public Business(String name, String address, String city, State state, String zip,
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
		int NUMERATOR = (rating1*1 + rating2*2 + rating3*3 + rating4*4 +rating5*5);
		int DENOMINATOR = (rating1+rating2+rating3+rating4+rating5);
		this.rating = DENOMINATOR > 0 ? (NUMERATOR/DENOMINATOR) : 0;
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

	public State getState() {
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

	public void setState(State state) {
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

	public static Business createExistingBusinessEntry(HttpServletRequest request) {
		
		// read form data
		String businessID = request.getParameter("businessID");
		int id = Integer.parseInt(businessID);
		String name = request.getParameter("businessName");
		String address = request.getParameter("businessAddress");
		String city = request.getParameter("businessCity");
		State state = State.valueOf(request.getParameter("businessState")); 
		String zip = request.getParameter("businessZip");
		String phone = request.getParameter("businessPhone");
		String website = request.getParameter("businessWebsite");
		String businessRating = request.getParameter("businessRating");
	
		// format parameters (strip non-digits, leading whitespace, etc.)
		name = name.replaceFirst("^\\s+", "");
		city = city.replaceFirst("^\\s+", "");
		address = address.replaceFirst("^\\s+", "");
		zip = zip.replaceAll("[^0-9]", "");
		phone = phone.replaceAll("[^0-9]", "");
		phone = phone.replaceFirst("^1", "");
	
		// rating breakdown
		int rating = businessRating != null ? Integer.parseInt(businessRating) : 0;
		
		int rating1 = 0;
		int rating2 = 0;
		int rating3 = 0;
		int rating4 = 0;
		int rating5 = 0;
		
		switch (rating) {
			case 1:	rating1 = 1;
					break;
			case 2:	rating2 = 1;
					break;
			case 3:	rating3 = 1;
					break;
			case 4:	rating4 = 1;
					break;
			case 5:	rating5 = 1;
					break;
		}
	
		// create business object (with existing id)
		Business existingBusiness = new Business(id, name, address, city, state, zip,
						phone, website, rating1, rating2, rating3, rating4, rating5);
		
		// return business
		return existingBusiness;
	}

	public static Business createNewBusinessEntry(HttpServletRequest request) {
		
		// read form data
		String name = request.getParameter("businessName");
		String address = request.getParameter("businessAddress");
		String city = request.getParameter("businessCity");
		State state = State.valueOf(request.getParameter("businessState")); 
		String zip = request.getParameter("businessZip");
		String phone = request.getParameter("businessPhone");
		String website = request.getParameter("businessWebsite");
		String businessRating = request.getParameter("businessRating");
	
		// format parameters (strip non-digits, leading whitespace, etc.)
		name = name.replaceFirst("^\\s+", "");
		city = city.replaceFirst("^\\s+", "");
		address = address.replaceFirst("^\\s+", "");
		zip = zip.replaceAll("[^0-9]", "");
		phone = phone.replaceAll("[^0-9]", "");
		phone = phone.replaceFirst("^1", "");
				
		// rating breakdown
		int rating = businessRating != null ? Integer.parseInt(businessRating) : 0;
		
		int rating1 = 0;
		int rating2 = 0;
		int rating3 = 0;
		int rating4 = 0;
		int rating5 = 0;
		
		switch (rating) {
			case 1:	rating1 = 1;
					break;
			case 2:	rating2 = 1;
					break;
			case 3:	rating3 = 1;
					break;
			case 4:	rating4 = 1;
					break;
			case 5:	rating5 = 1;
					break;
		}
	
		// create new business object (without existing id)
		Business newBusiness =  new Business(name, address, city, state, zip,
						phone, website, rating1, rating2, rating3, rating4, rating5);
		
		// return business
		return newBusiness;
	}	
	
}
