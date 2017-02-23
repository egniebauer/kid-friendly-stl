package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

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
		this(multipleFamilies, morning, afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
		this.businessID = businessID;
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
		this(multipleFamilies, morning, afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
		this.businessID = businessID;
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

	public static KidFriendlyDetail createKidFriendlyDetail(int businessID, HttpServletRequest request) 
			throws Exception {
		
		// create empty object
		KidFriendlyDetail newKidFriendlyDetail;
		
		// set params to false
		
		// retrieve data from form
		String multipleFamiliesRadio = request.getParameter("multipleFamilies");
		String kidsFreeDiscountRadio = request.getParameter("kidsFreeDiscount");
		String kidsFreeDiscountDetail = request.getParameter("kidsFreeDiscountDetail");
		String[] bestTimes = request.getParameterValues("bestTimes");
	
		// set params
		Boolean multipleFamilies = null;
		if (multipleFamiliesRadio != null) {
			multipleFamilies = multipleFamiliesRadio.equals("1") ? true : false;
		}
		Boolean kidsFreeDiscount = null;
		if (kidsFreeDiscountRadio !=null) {
			kidsFreeDiscount = kidsFreeDiscountRadio.equals("1") ? true : false;
		}
		
		boolean morning = false;
		boolean afternoon = false;
		boolean evening = false;
		if (bestTimes != null) {
			for (String time : bestTimes) {
				switch (time) {
					case "morning":
						morning = true;
						break;
					case "afternoon":
						afternoon = true;
						break;
					case "evening":
						evening = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newKidFriendlyDetail = new KidFriendlyDetail(businessID, multipleFamilies, morning, afternoon, evening, kidsFreeDiscount, kidsFreeDiscountDetail);
		return newKidFriendlyDetail;
	}

}
