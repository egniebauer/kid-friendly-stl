package com.kidfriendlystl;

public class RestaurantMenuInfo {
	
	private int businessID;
	private Boolean highChair;
	private Boolean booster;
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
		this.businessID = businessID;
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
		this.businessID = businessID;
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

	public Boolean isActivities() {
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

}
