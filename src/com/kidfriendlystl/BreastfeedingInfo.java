package com.kidfriendlystl;

public class BreastfeedingInfo {
	
	private int businessID;
	private Boolean clean;
	private Boolean comfortable;
	private Boolean bottleWarmer;
	private boolean lactationRoom;
	private boolean quietArea;
	private boolean grossOpts;
	private boolean nonSpecificOpts;
	
	public BreastfeedingInfo(int businessID, Boolean clean, Boolean comfortable, Boolean bottleWarmer,
			boolean lactationRoom, boolean quietArea, boolean grossOpts, boolean nonSpecificOpts) {
		this.businessID = businessID;
		this.clean = clean;
		this.comfortable = comfortable;
		this.bottleWarmer = bottleWarmer;
		this.lactationRoom = lactationRoom;
		this.quietArea = quietArea;
		this.grossOpts = grossOpts;
		this.nonSpecificOpts = nonSpecificOpts;
	}

	public BreastfeedingInfo(int businessID, boolean clean, boolean comfortable, boolean bottleWarmer,
			boolean lactationRoom, boolean quietArea, boolean grossOpts, boolean nonSpecificOpts) {
		this.businessID = businessID;
		this.clean = new Boolean(clean);
		this.comfortable = new Boolean(comfortable);
		this.bottleWarmer = new Boolean(bottleWarmer);
		this.lactationRoom = lactationRoom;
		this.quietArea = quietArea;
		this.grossOpts = grossOpts;
		this.nonSpecificOpts = nonSpecificOpts;
	}

	public BreastfeedingInfo(Boolean clean, Boolean comfortable, Boolean bottleWarmer, boolean lactationRoom,
			boolean quietArea, boolean grossOpts, boolean nonSpecificOpts) {
		this.clean = clean;
		this.comfortable = comfortable;
		this.bottleWarmer = bottleWarmer;
		this.lactationRoom = lactationRoom;
		this.quietArea = quietArea;
		this.grossOpts = grossOpts;
		this.nonSpecificOpts = nonSpecificOpts;
	}
	
	public BreastfeedingInfo(boolean clean, boolean comfortable, boolean bottleWarmer, boolean lactationRoom,
			boolean quietArea, boolean grossOpts, boolean nonSpecificOpts) {
		this.clean = new Boolean(clean);
		this.comfortable = new Boolean(comfortable);
		this.bottleWarmer = new Boolean(bottleWarmer);
		this.lactationRoom = lactationRoom;
		this.quietArea = quietArea;
		this.grossOpts = grossOpts;
		this.nonSpecificOpts = nonSpecificOpts;
	}

	public int getBusinessID() {
		return businessID;
	}

	public Boolean getClean() {
		return clean;
	}

	public Boolean getComfortable() {
		return comfortable;
	}

	public Boolean getBottleWarmer() {
		return bottleWarmer;
	}

	public boolean isLactationRoom() {
		return lactationRoom;
	}

	public boolean isQuietArea() {
		return quietArea;
	}

	public boolean isGrossOpts() {
		return grossOpts;
	}

	public boolean isNonSpecificOpts() {
		return nonSpecificOpts;
	}

	public void setBusinessID(int businessID) {
		this.businessID = businessID;
	}

	public void setClean(boolean clean) {
		this.clean = Boolean.valueOf(clean);
	}
	public void setClean(Boolean clean) {
		this.clean = clean;
	}

	public void setComfortable(boolean comfortable) {
		this.comfortable = Boolean.valueOf(comfortable);
	}
	public void setComfortable(Boolean comfortable) {
		this.comfortable = comfortable;
	}

	public void setBottleWarmer(boolean bottleWarmer) {
		this.bottleWarmer = Boolean.valueOf(bottleWarmer);
	}
	public void setBottleWarmer(Boolean bottleWarmer) {
		this.bottleWarmer = bottleWarmer;
	}

	public void setLactationRoom(boolean lactationRoom) {
		this.lactationRoom = lactationRoom;
	}

	public void setQuietArea(boolean quietArea) {
		this.quietArea = quietArea;
	}

	public void setGrossOpts(boolean grossOpts) {
		this.grossOpts = grossOpts;
	}

	public void setNonSpecificOpts(boolean nonSpecificOpts) {
		this.nonSpecificOpts = nonSpecificOpts;
	}

}
