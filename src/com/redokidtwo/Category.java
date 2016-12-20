package com.redokidtwo;

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
		this.businessID = businessID;
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
	
}
