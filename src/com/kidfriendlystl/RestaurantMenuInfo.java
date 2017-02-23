package com.kidfriendlystl;

import javax.servlet.http.HttpServletRequest;

public class RestaurantMenuInfo {
	
	private int businessID;
	private boolean highChair;
	private boolean booster;
	private Boolean activities;
	
	// kidsMenu
	private boolean healthy;
	private boolean allergyFriendly;
	private boolean unhealthy;
	private boolean noKidsMenu;
	
	// full menu options
	private boolean manyOpts;
	private boolean someOpts;
	private boolean fewOpts;
	private boolean noOpts;
	
	public RestaurantMenuInfo(int businessID, boolean highChair, boolean booster, Boolean activities, boolean healthy,
			boolean allergyFriendly, boolean unhealthy, boolean noKidsMenu, boolean manyOpts, boolean someOpts, boolean fewOpts,
			boolean noOpts) {
		this(highChair, booster, activities, healthy, allergyFriendly, unhealthy, noKidsMenu, manyOpts, someOpts, fewOpts, noOpts);
		this.businessID = businessID;
	}

	public RestaurantMenuInfo(boolean highChair, boolean booster, Boolean activities, boolean healthy, boolean allergyFriendly,
			boolean unhealthy, boolean noKidsMenu, boolean manyOpts, boolean someOpts, boolean fewOpts, boolean noOpts) {
		this.highChair = highChair;
		this.booster = booster;
		this.activities = activities;
		this.healthy = healthy;
		this.allergyFriendly = allergyFriendly;
		this.unhealthy = unhealthy;
		this.noKidsMenu = noKidsMenu;
		this.manyOpts = manyOpts;
		this.someOpts = someOpts;
		this.fewOpts = fewOpts;
		this.noOpts = noOpts;
	}
	
	public RestaurantMenuInfo(int businessID, boolean highChair, boolean booster, boolean activities, boolean healthy,
			boolean allergyFriendly, boolean unhealthy, boolean noKidsMenu, boolean manyOpts, boolean someOpts, boolean fewOpts,
			boolean noOpts) {
		this(highChair, booster, activities, healthy, allergyFriendly, unhealthy, noKidsMenu, manyOpts, someOpts, fewOpts, noOpts);
		this.businessID = businessID;
	}

	public RestaurantMenuInfo(boolean highChair, boolean booster, boolean activities, boolean healthy, boolean allergyFriendly,
			boolean unhealthy, boolean noKidsMenu, boolean manyOpts, boolean someOpts, boolean fewOpts, boolean noOpts) {
		this.highChair = highChair;
		this.booster = booster;
		this.activities = new Boolean(activities);
		this.healthy = healthy;
		this.allergyFriendly = allergyFriendly;
		this.unhealthy = unhealthy;
		this.noKidsMenu = noKidsMenu;
		this.manyOpts = manyOpts;
		this.someOpts = someOpts;
		this.fewOpts = fewOpts;
		this.noOpts = noOpts;
	}

	public int getBusinessID() {
		return businessID;
	}

	public boolean isHighChair() {
		return highChair;
	}

	public boolean isBooster() {
		return booster;
	}

	public Boolean getActivities() {
		return activities;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public boolean isAllergyFriendly() {
		return allergyFriendly;
	}

	public boolean isUnhealthy() {
		return unhealthy;
	}

	public boolean isNoKidsMenu() {
		return noKidsMenu;
	}

	public boolean isManyOpts() {
		return manyOpts;
	}

	public boolean isSomeOpts() {
		return someOpts;
	}

	public boolean isFewOpts() {
		return fewOpts;
	}

	public boolean isNoOpts() {
		return noOpts;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public void setHighChair(boolean highChair) {
		this.highChair = highChair;
	}

	public void setBooster(boolean booster) {
		this.booster = booster;
	}

	public void setActivities(Boolean activities) {
		this.activities = activities;
	}

	public void setActivities(boolean activities) {
		this.activities = Boolean.valueOf(activities);
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}

	public void setAllergyFriendly(boolean allergyFriendly) {
		this.allergyFriendly = allergyFriendly;
	}

	public void setUnhealthy(boolean unhealthy) {
		this.unhealthy = unhealthy;
	}

	public void setNoKidsMenu(boolean noKidsMenu) {
		this.noKidsMenu = noKidsMenu;
	}

	public void setManyOpts(boolean manyOpts) {
		this.manyOpts = manyOpts;
	}

	public void setSomeOpts(boolean someOpts) {
		this.someOpts = someOpts;
	}

	public void setFewOpts(boolean fewOpts) {
		this.fewOpts = fewOpts;
	}

	public void setNoOpts(boolean noOpts) {
		this.noOpts = noOpts;
	}

	public static RestaurantMenuInfo createRestaurantMenu(int businessID, HttpServletRequest request) 
			throws Exception {
		// create empty object
		RestaurantMenuInfo newRestaurantMenuInfo;
		
		// retrieve data
		String activitiesRadio = request.getParameter("activities");
		String[] seatingOptions = request.getParameterValues("seating");
		String[] kidsMenu = request.getParameterValues("kidsMenu");
		String[] fullMenu = request.getParameterValues("fullMenu");
		
		// set data to params
		Boolean activities = null;
		if (activitiesRadio != null) {
			activities = activitiesRadio.equals("1") ? true : false;
		}
	
		boolean highChair = false;
		boolean booster = false;
		if (seatingOptions != null){
			for (String option : seatingOptions) {
				switch (option){
					case "highChair" :
						highChair = true;
						break;
					case "booster" :
						booster = true;
						break;
				}
			}
		}
		
		boolean healthy = false;
		boolean allergyFriendly = false;
		boolean unhealthy = false;
		boolean noKidsMenu = false;		
		if (kidsMenu != null) {
			for (String option : kidsMenu) {
				switch (option){
					case "healthy" :
						healthy = true;
						break;
					case "allergyFriendly" :
						allergyFriendly = true;
						break;
					case "unhealthy" :
						unhealthy = true;
						break;
					case "noKidsMenu" :
						noKidsMenu = true;
						break;
				}
			}
		}
		
		boolean manyOpts = false;
		boolean someOpts = false;
		boolean fewOpts = false;
		boolean noOpts = false;	
		if (fullMenu != null) {
			for (String option : fullMenu) {
				switch (option){
					case "manyOpts" :
						manyOpts = true;
						break;
					case "someOpts" :
						someOpts = true;
						break;
					case "fewOpts" :
						fewOpts = true;
						break;
					case "noOpts" :
						noOpts = true;
						break;
				}
			}
		}
		
		// pass params to object and return
		newRestaurantMenuInfo = new RestaurantMenuInfo(businessID, highChair, booster, activities, healthy, allergyFriendly, unhealthy, noKidsMenu, manyOpts, someOpts, fewOpts, noOpts);
		return newRestaurantMenuInfo;
	}

}
