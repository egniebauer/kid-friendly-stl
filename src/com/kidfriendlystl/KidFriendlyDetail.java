package com.kidfriendlystl;

public class KidFriendlyDetail {
	
	private int businessID;
	private Boolean multipleFamilies;
	private boolean morning;
	private boolean afternoon;
	private boolean evening;
	private Boolean kidsFreeDiscount;
	private String kidsFreeDiscountDetail;
	
	public KidFriendlyDetail(int businessID, Boolean multipleFamilies, boolean morning,
			boolean afternoon, boolean evening, Boolean kidsFreeDiscount, String kidsFreeDiscountDetail) {
		this.businessID = businessID;
		this.multipleFamilies = multipleFamilies;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.kidsFreeDiscount = kidsFreeDiscount;
		this.kidsFreeDiscountDetail = kidsFreeDiscountDetail;
	}

	public KidFriendlyDetail(Boolean multipleFamilies, boolean morning,
			boolean afternoon, boolean evening, Boolean kidsFreeDiscount, String kidsFreeDiscountDetail) {
		this.multipleFamilies = multipleFamilies;
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.kidsFreeDiscount = kidsFreeDiscount;
		this.kidsFreeDiscountDetail = kidsFreeDiscountDetail;
	}
	
	public KidFriendlyDetail(int businessID, boolean multipleFamilies, boolean morning,
			boolean afternoon, boolean evening, boolean kidsFreeDiscount, String kidsFreeDiscountDetail) {
		this.businessID = businessID;
		this.multipleFamilies = new Boolean(multipleFamilies);
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.kidsFreeDiscount = new Boolean (kidsFreeDiscount);
		this.kidsFreeDiscountDetail = kidsFreeDiscountDetail;
	}

	public KidFriendlyDetail(boolean multipleFamilies, boolean morning,
			boolean afternoon, boolean evening, boolean kidsFreeDiscount, String kidsFreeDiscountDetail) {
		this.multipleFamilies = new Boolean(multipleFamilies);
		this.morning = morning;
		this.afternoon = afternoon;
		this.evening = evening;
		this.kidsFreeDiscount = new Boolean (kidsFreeDiscount);
		this.kidsFreeDiscountDetail = kidsFreeDiscountDetail;
	}

	public int getBusinessID() {
		return businessID;
	}

	public Boolean getMultipleFamilies() {
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

	public Boolean getKidsFreeDiscount() {
		return kidsFreeDiscount;
	}

	public String getKidsFreeDiscountDetail() {
		return kidsFreeDiscountDetail;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public void setMultipleFamilies(boolean multipleFamilies) {
		this.multipleFamilies = Boolean.valueOf(multipleFamilies);
	}
	public void setMultipleFamilies(Boolean multipleFamilies) {
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
		this.kidsFreeDiscount = Boolean.valueOf(kidsFreeDiscount);
	}
	public void setKidsFreeDiscount(Boolean kidsFreeDiscount) {
		this.kidsFreeDiscount = kidsFreeDiscount;
	}

	public void setKidsFreeDiscountDetail(String kidsFreeDiscountDetail) {
		this.kidsFreeDiscountDetail = kidsFreeDiscountDetail;
	}

}
