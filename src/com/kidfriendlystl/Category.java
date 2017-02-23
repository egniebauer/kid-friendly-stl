package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

public class Category {
	
	private int businessID;							// *required
	private boolean activeLife;
	private boolean artsEntertainment;
	private boolean education;
	private boolean foodRestaurant;
	private boolean healthMedical;
	private boolean hotelTravel;
	private boolean publicServiceGovernment;
	private boolean religious;
	private boolean shopping;
	
	public Category(int businessID, boolean activeLife, boolean artsEntertainment, boolean education,
			boolean foodRestaurant, boolean healthMedical, boolean hotelTravel, boolean publicServiceGovernment,
			boolean religious, boolean shopping) {
		this(activeLife, artsEntertainment, education, foodRestaurant, healthMedical, hotelTravel, publicServiceGovernment, religious, shopping);
		this.businessID = businessID;
	}

	public Category(boolean activeLife, boolean artsEntertainment, boolean education,
			boolean foodRestaurant, boolean healthMedical, boolean hotelTravel, boolean publicServiceGovernment,
			boolean religious, boolean shopping) {
		this.activeLife = activeLife;
		this.artsEntertainment = artsEntertainment;
		this.education = education;
		this.foodRestaurant = foodRestaurant;
		this.healthMedical = healthMedical;
		this.hotelTravel = hotelTravel;
		this.publicServiceGovernment = publicServiceGovernment;
		this.religious = religious;
		this.shopping = shopping;
	}

	public int getBusinessID() {
		return businessID;
	}

	public boolean isActiveLife() {
		return activeLife;
	}

	public boolean isArtsEntertainment() {
		return artsEntertainment;
	}

	public boolean isEducation() {
		return education;
	}

	public boolean isFoodRestaurant() {
		return foodRestaurant;
	}

	public boolean isHealthMedical() {
		return healthMedical;
	}

	public boolean isHotelTravel() {
		return hotelTravel;
	}

	public boolean isPublicServiceGovernment() {
		return publicServiceGovernment;
	}

	public boolean isReligious() {
		return religious;
	}

	public boolean isShopping() {
		return shopping;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public void setActiveLife(boolean activeLife) {
		this.activeLife = activeLife;
	}

	public void setArtsEntertainment(boolean artsEntertainment) {
		this.artsEntertainment = artsEntertainment;
	}

	public void setEducation(boolean education) {
		this.education = education;
	}

	public void setFoodRestaurant(boolean foodRestaurant) {
		this.foodRestaurant = foodRestaurant;
	}

	public void setHealthMedical(boolean healthMedical) {
		this.healthMedical = healthMedical;
	}

	public void setHotelTravel(boolean hotelTravel) {
		this.hotelTravel = hotelTravel;
	}

	public void setPublicServiceGovernment(boolean publicServiceGovernment) {
		this.publicServiceGovernment = publicServiceGovernment;
	}

	public void setReligious(boolean religious) {
		this.religious = religious;
	}

	public void setShopping(boolean shopping) {
		this.shopping = shopping;
	}

	public static Category createCategory(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create an empty Category object
		Category newCategory;
		
		// retrieve form data
		String[] categories = request.getParameterValues("category"); 
		
		// assign data to params
		boolean activeLife = false;
		boolean artsEntertainment = false;
		boolean education = false;
		boolean foodRestaurant = false;
		boolean healthMedical = false;
		boolean hotelTravel = false;
		boolean publicServiceGovernment = false;
		boolean religious = false;
		boolean shopping = false;
		
		if (categories != null) {
			for (String category : categories) {
				switch (category) {
					case "activeLife":
						activeLife = true;
						break;
					case "artsEntertainment":
						artsEntertainment = true;
						break;
					case "education":
						education = true;
						break;
					case "foodRestaurant":
						foodRestaurant = true;
						break;
					case "healthMedical":
						healthMedical = true;
						break;
					case "hotelTravel":
						hotelTravel = true;
						break;
					case "publicServiceGovernment":
						publicServiceGovernment = true;
						break;
					case "religious":
						religious = true;
						break;
					case "shopping":
						shopping = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newCategory= new Category (businessID, activeLife, artsEntertainment, education, foodRestaurant, healthMedical, hotelTravel, publicServiceGovernment, religious, shopping);
		return newCategory;
	}
	
}
