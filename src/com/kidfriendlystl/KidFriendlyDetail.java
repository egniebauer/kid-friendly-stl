package com.kidfriendlystl;

public class KidFriendlyDetail {
	
	private int businessID;
	private boolean multipleFamilies;
	private boolean morning;
	private boolean afternoon;
	private boolean evening;
	private boolean kidsFreeDiscount;
	private String kidsFreeDiscountDetail;
	
	public KidFriendlyDetail(int businessID, boolean multipleFamilies, boolean morning,
			boolean afternoon, boolean evening, boolean kidsFreeDiscount, String kidsFreeDiscountDetail) {
		this.businessID = businessID;
		this.multipleFamilies = multipleFamilies;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.kidsFreeDiscount = kidsFreeDiscount;
		this.kidsFreeDiscountDetail = kidsFreeDiscountDetail;
	}

	public KidFriendlyDetail(boolean multipleFamilies, boolean morning,
			boolean afternoon, boolean evening, boolean kidsFreeDiscount, String kidsFreeDiscountDetail) {
		this.multipleFamilies = multipleFamilies;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.kidsFreeDiscount = kidsFreeDiscount;
		this.kidsFreeDiscountDetail = kidsFreeDiscountDetail;
	}

	public int getBusinessID() {
		return businessID;
	}

	public boolean isMultipleFamilies() {
		return multipleFamilies;
	}

	public boolean isMorning() {
		return morning;
	}

	public boolean isAfternoon() {
		return afternoon;
	}

	public boolean isEvening() {
		return evening;
	}

	public boolean isKidsFreeDiscount() {
		return kidsFreeDiscount;
	}

	public String getKidsFreeDiscountDetail() {
		return kidsFreeDiscountDetail;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public void setMultipleFamilies(boolean multipleFamilies) {
		this.multipleFamilies = multipleFamilies;
	}

	public void setMorning(boolean morning) {
		this.morning = morning;
	}

	public void setAfternoon(boolean afternoon) {
		this.afternoon = afternoon;
	}

	public void setEvening(boolean evening) {
		this.evening = evening;
	}

	public void setKidsFreeDiscount(boolean kidsFreeDiscount) {
		this.kidsFreeDiscount = kidsFreeDiscount;
	}

	public void setKidsFreeDiscountDetail(String kidsFreeDiscountDetail) {
		this.kidsFreeDiscountDetail = kidsFreeDiscountDetail;
	}

}
